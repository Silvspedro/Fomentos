let a = document.getElementById("lixeira");

const apagar = (i) => {
    document.getElementsByClassName("card mb-3")[i].setAttribute("style","display:none");
}

a.onclick(apagar);