 let divh = document.getElementById("heartId");
    let svgh = document.getElementById("heartSvg");
    let divc = document.getElementById("cartId");
    let svgc = document.getElementById("cartSvg");

  divh.onmouseover=function(){
    divh.style.background = "white";
    svgh.style.fill = "#000000";
  }
  divh.onmouseout=function(){
    divh.style.background = "#000000";
    svgh.style.fill = "white";
  }

  divc.onmouseover=function(){
    divc.style.background = "white";
    svgc.style.fill = "#00dfff";
  }
  divc.onmouseout=function(){
    divc.style.background = "#00dfff";
    svgc.style.fill = "white";
  }





  //マウスアウト時の処理を記述
