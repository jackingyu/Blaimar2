var onlyOpenTitle="简介";//不允许关闭的标签的标题

window.onload = function(){
	$('#loading-mask').fadeOut();
}

ACC.main = {
	initLeftMenu:function(){
		$("#nav").accordion({animate:false,fit:true,border:false});
		var selectedPanelname = '';
		$.ajax({
			type:'GET',
			url:ACC.config.contextPath+'/getMenu',
			success:function(result){
				$.each(result, function(i, n) {
			    	var menulist = juicer($('#menuTmpl').html(),n);
					$('#nav').accordion('add', {
			            title: n.menuname,
			            content: menulist,
						border:false,
			            iconCls: 'icon ' + n.icon
			        });

					if(i==0)
						selectedPanelname =n.menuname;

			    });
			}
		});
	    
		$('#nav').accordion('select',selectedPanelname);



		$('.navlist li a').click(function(){
			var tabTitle = $(this).children('.nav').text();

			var url = $(this).attr("rel");
			var menuid = $(this).attr("ref");
			var icon = $(this).find('.icon').attr('class');

			var third = ACC.main.findMenu(menuid);
			if(third && third.child && third.child.length>0)
			{
				$('.third_ul').slideUp();

				var ul =$(this).parent().next();
				if(ul.is(":hidden"))
					ul.slideDown();
				else
					ul.slideUp();



			}
			else{
				ACC.main.addTab(tabTitle,url,icon);
				$('.navlist li div').removeClass("selected");
				$(this).parent().addClass("selected");
			}
		}).hover(function(){
			$(this).parent().addClass("hover");
		},function(){
			$(this).parent().removeClass("hover");
		});

		//选中第一个
		//var panels = $('#nav').accordion('panels');
		//var t = panels[0].panel('options').title;
	    //$('#nav').accordion('select', t);
	},
	tabClose:function(){
		/*双击关闭TAB选项卡*/
		$(".tabs-inner").dblclick(function(){
			var subtitle = $(this).children(".tabs-closable").text();
			$('#tabs').tabs('close',subtitle);
		})
		/*为选项卡绑定右键*/
		$(".tabs-inner").bind('contextmenu',function(e){
			$('#mm').menu('show', {
				left: e.pageX,
				top: e.pageY
			});

			var subtitle =$(this).children(".tabs-closable").text();

			$('#mm').data("currtab",subtitle);
			$('#tabs').tabs('select',subtitle);
			return false;
		});
	},
	tabCloseEven:function(){
		$('#mm').menu({
	        onClick: function (item) {
	            ACC.main.closeTab(item.id);
	        }
	    });

	    return false;
	},
	closeTab:function(action)
	{
	    var alltabs = $('#tabs').tabs('tabs');
	    var currentTab =$('#tabs').tabs('getSelected');
		var allTabtitle = [];
		$.each(alltabs,function(i,n){
			allTabtitle.push($(n).panel('options').title);
		})


	    switch (action) {
	        case "refresh":
	            var iframe = $(currentTab.panel('options').content);
	            var src = iframe.attr('src');
	            $('#tabs').tabs('update', {
	                tab: currentTab,
	                options: {
	                    content: createFrame(src)
	                }
	            })
	            break;
	        case "close":
	            var currtab_title = currentTab.panel('options').title;
	            $('#tabs').tabs('close', currtab_title);
	            break;
	        case "closeall":
	            $.each(allTabtitle, function (i, n) {
	                if (n != onlyOpenTitle){
	                    $('#tabs').tabs('close', n);
					}
	            });
	            break;
	        case "closeother":
	            var currtab_title = currentTab.panel('options').title;
	            $.each(allTabtitle, function (i, n) {
	                if (n != currtab_title && n != onlyOpenTitle)
					{
	                    $('#tabs').tabs('close', n);
					}
	            });
	            break;
	        case "closeright":
	            var tabIndex = $('#tabs').tabs('getTabIndex', currentTab);

	            if (tabIndex == alltabs.length - 1){
	                alert('亲，后边没有啦 ^@^!!');
	                return false;
	            }
	            $.each(allTabtitle, function (i, n) {
	                if (i > tabIndex) {
	                    if (n != onlyOpenTitle){
	                        $('#tabs').tabs('close', n);
						}
	                }
	            });

	            break;
	        case "closeleft":
	            var tabIndex = $('#tabs').tabs('getTabIndex', currentTab);
	            if (tabIndex == 1) {
	                alert('亲，前边那个上头有人，咱惹不起哦。 ^@^!!');
	                return false;
	            }
	            $.each(allTabtitle, function (i, n) {
	                if (i < tabIndex) {
	                    if (n != onlyOpenTitle){
	                        $('#tabs').tabs('close', n);
						}
	                }
	            });

	            break;
	        case "exit":
	            $('#closeMenu').menu('hide');
	            break;
	    }
	},
	//获取左侧导航的图标
	getIcon:function(menuid){
		var icon = 'icon ';
		$.each(_menus.menus, function(i, n) {
			 $.each(n.menus, function(j, o) {
			 	if(o.menuid==menuid){
					icon += o.icon;
				}
			 })
		})

		return icon;
	},
	
	findMenu:function(menuid){
		var obj=null;
		$.each(_menus.menus, function(i, n) {
			 $.each(n.menus, function(j, o) {
			 	if(o.menuid==menuid){
					obj = o;
				}
			 });
		});

		return obj;
	},

	addTab:function(subtitle,url,icon){
		if(!$('#tabs').tabs('exists',subtitle)){
			$('#tabs').tabs('add',{
				title:subtitle,
				href:ACC.config.contextPath+url,
				closable:true,
				icon:icon
			});
		}else{
			$('#tabs').tabs('select',subtitle);
			$('#mm-tabupdate').click();
		}
		ACC.main.tabClose();
	},
	//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
	msgShow:function msgShow(title, msgString, msgType) {
		$.messager.alert(title, msgString, msgType);
	}
}

$(document).ready(function ()
{
	juicer.set({
	    'tag::operationOpen': '{@',
	    'tag::operationClose': '}',
	    'tag::interpolateOpen': '$(',
	    'tag::interpolateClose': ')',
	    'tag::noneencodeOpen': '$${',
	    'tag::noneencodeClose': '}',
	    'tag::commentOpen': '{#',
	    'tag::commentClose': '}'
	});
	
	ACC.main.initLeftMenu();
	ACC.main.tabClose();
	ACC.main.tabCloseEven();
		
});



