document.onreadystatechange = function() {
  grid = document.getElementById("grid");
  button = document.getElementById("button");
  button.addEventListener("click", generateGrid);
  testMode = false; //Turn this variable to true to see where the mines are
  generateGrid();

  function generateGrid() {
    //generate 10 by 10 grid
    grid.innerHTML="";
    for (i=0; i<10; i++) {
      row = grid.insertRow(i);
      for (j=0; j<10; j++) {
        cell = row.insertCell(j);
        cell.onclick = function() { clickCell(this); };
        mine = document.createAttribute("data-mine");       
        mine.value = "false";             
        cell.setAttributeNode(mine);
      }
    }
    addMines();
  }

  

  function addMines() {
    //Add mines randomly
    for (i=0; i<20; i++) {
      row = Math.floor(Math.random() * 10);
      col = Math.floor(Math.random() * 10);
      cell = grid.rows[row].cells[col];
      cell.setAttribute("data-mine","true");
      if (testMode) cell.innerHTML="X";
    }
  }

  function revealMines() {
      //Highlight all mines in red
      for ( i=0; i<10; i++) {
        for( j=0; j<10; j++) {
           cell = grid.rows[i].cells[j];
          if (cell.getAttribute("data-mine")=="true") cell.className="mine";
        }
      }
  }

  function checkLevelCompletion() {
     levelComplete = true;
      for ( i=0; i<10; i++) {
        for( j=0; j<10; j++) {
          if ((grid.rows[i].cells[j].getAttribute("data-mine")=="false") && (grid.rows[i].cells[j].innerHTML=="")) levelComplete=false;
        }
    }
    if (levelComplete) {
      alert("You Win!");
      revealMines();
    }
  }

  function clickCell(cell) {
    //Check if the end-user clicked on a mine
    if (cell.getAttribute("data-mine")=="true") {
      revealMines();
      alert("Game Over");
    } else {
      cell.className="clicked";
      //Count and display the number of adjacent mines
       mineCount=0;
       cellRow = cell.parentNode.rowIndex;
       cellCol = cell.cellIndex;
      //alert(cellRow + " " + cellCol);
      for ( i=Math.max(cellRow-1,0); i<=Math.min(cellRow+1,9); i++) {
        for( j=Math.max(cellCol-1,0); j<=Math.min(cellCol+1,9); j++) {
          if (grid.rows[i].cells[j].getAttribute("data-mine")=="true") mineCount++;
        }
      }
      cell.innerHTML=mineCount;
      if (mineCount==0) { 
        //Reveal all adjacent cells as they do not have a mine
        for ( i=Math.max(cellRow-1,0); i<=Math.min(cellRow+1,9); i++) {
          for( j=Math.max(cellCol-1,0); j<=Math.min(cellCol+1,9); j++) {
            //Recursive Call
            if (grid.rows[i].cells[j].innerHTML=="") clickCell(grid.rows[i].cells[j]);
          }
        }
      }
      checkLevelCompletion();
    }
  }
}