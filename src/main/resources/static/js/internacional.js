var check=document.querySelector(".check");
check.addEventListener('click',idioma);

function idioma(){
    let id=check.checked;
    if (id==true){
        location.href="en/alimentacion.html";
    }else{
        location.href="../alimentacion.html";
    }
}