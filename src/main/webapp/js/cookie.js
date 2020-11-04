document.onreadystatechange = function(){
	games = ["football", "snake", "tetris", "minesweeper", "bomberman", "breakout", "frogger", "pong"];
	
	for (let i = 0; i < 8; i++) {
		
		if (document.getElementById(games[i]) != null) {
			document.getElementById(games[i]).addEventListener("click", function() {
				document.cookie = "game=" + games[i];
				
			});
		}
	}
}