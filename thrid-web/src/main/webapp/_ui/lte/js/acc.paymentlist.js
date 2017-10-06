ACC.paymentList = {
  query: function () {
    $('#paymentGrid').dataTable().fnDraw();
  },
  init: function ()
  {
    $('#paymentGrid').DataTable({
       'createdRow': function (row, data, index) {
        $('td', row).eq(2).html(
           '<a  href="'+ACC.config.contextPath+"/order/modifyorderpage/"+data[2]+'" >'+data[2]+'</a>'
        );
      },
      'ajax': {
        'url': ACC.config.contextPath + '/payment/getlist',
        'data': function (d) {
           var deliveryDate = getDate4Range($("#paymentDate").val());
           d.startDate = deliveryDate[0];
           d.endDate = moment(deliveryDate[1]).add(1,'days').format('YYYY-MM-DD');
           d.storeCodes = $('#storeCodes').val()!=null?$('#storeCodes').val().toString():'';
           d.sourcePKs = $('#sourcePKs').val()!=null?$('#sourcePKs').val().toString():'';
           d.paymentMethods = $('#paymentMethods').val()!=null?$('#paymentMethods').val().toString():'';
           d.orderStatus = $('#orderStatus').val()!=null?$('#orderStatus').val().toString():'';
           d.salesPersons = $('#salesPersons').val()!=null?$('#salesPersons').val().toString():'';
       
        }
      },
      'fnDrawCallback': function () {
      }
    });
    
    $('#paymentDate').daterangepicker({
      locale:datepicker_locale_zh,
      startDate:moment().subtract(1, 'months'),
      endDate: moment().add(1,'days')
    }
    );
    
    if($("#sourcePKs").val()!=null)
     $("#sourcePKs").val(null).trigger("change");
     
    if($("#storeCodes").val()!=null)
     $("#storeCodes").val(null).trigger("change");
     
    if($("#salesPersons").val()!=null)
     $("#salesPersons").val(null).trigger("change");
    
  }
}

$(document).ready(function ()
{
  ACC.paymentList.init();
});
