let a = document.getElementById("lixeira");

const apagar = (i) => {
    document.getElementsByClassName("favorite")[i].setAttribute("style","display:none");
}

a.onclick(apagar);