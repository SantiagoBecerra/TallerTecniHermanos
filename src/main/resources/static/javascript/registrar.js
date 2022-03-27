$(document).ready(function () {
    $('.search_select_box select').selectpicker();
     var val = $("#idre").val();
     console.log(val)
    $("input").attr({
        "max" : val,        // substitute your own
        "min" : 1         // values (or variables) here
    });
   /* document.getElementById("fh").setAttribute("max", getToday());*/
})
$('options').change(function(){
    var val = $("#idre").val();
    console.log(val);
    $('input[type=number]').attr('max', val);
});
/*document.getElementById("agregar").onclick = function () {
    addRepuesto()
};*/
function getToday(){
    let today = new Date();
    let dd = today.getDate();
    let mm = today.getMonth() + 1;
    let yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd;
    }
    if (mm < 10) {
        mm = '0' + mm;
    }
    today = yyyy + '-' + mm + '-' + dd;
    return today
}
function PrintElem(elem)
{
    var printContents = document.getElementById(elem).innerHTML;
    var originalContents = document.body.innerHTML;

    document.body.innerHTML = printContents;

    window.print();

    document.body.innerHTML = originalContents;

    return true;
}

