var canvas;
var ctx; // !!! context 2D (drawing)

var engine;
var holdButtonMouse = false;
var oldMouse = new Vector(0,0);

window.addEventListener("load",main);

function handleMouseDown(event) {
  holdButtonMouse = true;
  // get the mouse relative to canvas
  var mouseX = event.layerX-canvas.offsetLeft;
  var mouseY = event.layerY-canvas.offsetTop;
  var mouse=new Vector(mouseX,mouseY);

  oldMouse = mouse;

  engine.obstacleManager.select(mouse);
  engine.particleManager.select(mouse);

  if (engine.particleManager.selected != null || engine.obstacleManager.selected != null) {
  	if (engine.particleManager.selected != null && engine.obstacleManager.selected != null) {
  		var dist = engine.particleManager.selected.distance(mouse);

  		if (engine.obstacleManager.selected.distance(mouse) < dist) {
  			engine.particleManager.selected = null;
  			engine.obstacleManager.selected.color = 'green';
  		}
  		else
	  		engine.obstacleManager.selected = null;
	  }

	  else if(engine.obstacleManager.selected != null) {
	  	engine.obstacleManager.selected.color = 'green';
	  }
  }

  console.log(engine.particleManager.selected);
  console.log(engine.obstacleManager.selected);
}

function handleMouseMove(event) {
  if(holdButtonMouse && (engine.particleManager.selected != null || engine.obstacleManager.selected != null)){
    var mouseX = event.layerX-canvas.offsetLeft;
    var mouseY = event.layerY-canvas.offsetTop;
    var mouse=new Vector(mouseX,mouseY);
    //engine.particleManager.selected.move(mouse.x-oldMouse.x,mouse.y-oldMouse.y);
    //oldMouse.setXY(mouse.x,mouse.y);
    if (engine.particleManager.selected != null){
      engine.particleManager.selected.move(mouse.x - oldMouse.x, mouse.y - oldMouse.y);
    }
		else{
      engine.obstacleManager.selected.move(mouse.x - oldMouse.x, mouse.y - oldMouse.y);
    }

		oldMouse = mouse;
  }
}

function handleMouseUp(event) {
  holdButtonMouse = false;
  if (engine.obstacleManager.selected != null){
    engine.obstacleManager.selected.color = 'red';
  }
}

function scenefinal() {
   	canvas=document.getElementById("canvas");
  	ctx=canvas.getContext("2d");

    engine=new Engine();

    var gen1 = new GeneratorBox();
    gen1.min.setXY(0,0);
    gen1.max.setXY(500,0);



    engine.particleManager.generatorList.push(gen1);

    canvas.addEventListener('mousedown',handleMouseDown,false);
    canvas.addEventListener('mousemove',handleMouseMove,false);
    canvas.addEventListener('mouseup',handleMouseUp,false);


    var obs1=new Segment(new Vector(500,350),new Vector(500,500));
    var obs2=new Segment(new Vector(400,300),new Vector(500,350));
    var obs3=new Segment(new Vector(300,355),new Vector(410,300));
    var obs4=new Segment(new Vector(0,355),new Vector(315,350));
    var obs5=new Circle(new Vector(0,50),50);
    engine.obstacleManager.obstacleList.push(obs1,obs2,obs3,obs4,obs5);

    engine.start();
}

function main() {
   	scenefinal();
}
