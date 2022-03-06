$(document).ready(function () {
    $('.search_select_box select').selectpicker();
    document.getElementById("fh").setAttribute("max", getToday());
})
document.getElementyId("agregar").onclick = function () {
    addRepuesto()
};

function addRepuesto() {

}
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

