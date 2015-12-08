function validateNumber(evt) {

    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if ((charCode < 48 || charCode > 57))
        return false;
    return true;
}
;


