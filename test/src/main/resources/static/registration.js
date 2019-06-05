$(document).ready(function() {
	$(".disable").disabled = true;
  });

$(".date").change(function(){
	var date = $('.date option:selected').val();
	var month = $('.month option:selected').val();
	var year = $('.year option:selected').val();
	if (date != "Date" && month != "Month" && year != "Year") {
		var dateofbirth = date + '-' + month + '-' + year;
		$("#dob").val(dateofbirth);
	} else {
		var dateofbirth = null;
		$("#dob").val(dateofbirth);
	}
});

$(".month").change(function(){	
	var date = $('.date option:selected').val();
	var month = $('.month option:selected').val();
	var year = $('.year option:selected').val();
	if (date != "Date" && month != "Month" && year != "Year") {
		var dateofbirth = date + '-' + month + '-' + year;
		$("#dob").val(dateofbirth);
	} else {
		var dateofbirth = null;
		$("#dob").val(dateofbirth);
	}
});

$(".year").change(function(){	
	var date = $('.date option:selected').val();
	var month = $('.month option:selected').val();
	var year = $('.year option:selected').val();
	if (date != "Date" && month != "Month" && year != "Year") {
		var dateofbirth = date + '-' + month + '-' + year;
		$("#dob").val(dateofbirth);
	} else {
		var dateofbirth = null;
		$("#dob").val(dateofbirth);
	}
});

$('input[type=radio][name=gd]').change(function() {
	    var n = this.value;
        $("#gender").val(n);
});