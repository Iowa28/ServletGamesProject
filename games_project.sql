

--
-- База данных: `qwerty`
-- 


-- --------------------------------------------------------




--
-- Структура таблицы `users_info`
--

CREATE TABLE users_info (
	Id SERIAL PRIMARY KEY,
	Country varchar(30),
	City varchar(80),
	Date_Of_Birth varchar(80)
);

--
-- Дамп данных таблицы `users_info`
--

INSERT INTO users_info(Country, City, Date_Of_Birth) values 
('Russia', 'Kazan', '15-08-1999'),
('USA', 'California', '30-05-2005'),
('UK', 'London', '07-02-1985');




--
-- Структура таблицы `users`
--

CREATE TABLE users (
	Id SERIAL PRIMARY KEY,
	Name varchar(30),
	Email varchar(80),
	Password varchar(80),
	users_info_id int references "users_info"(Id) on update restrict on delete cascade
);

--
-- Дамп данных таблицы `users`
--

INSERT INTO users(Name, Email, Password, users_info_id) values 
('Niaz', 'aminovnf@list.ru', '12345', 1),
('Admin', 'testing@mail.ru', 'abc', 2),
('Bobby', 'bobby@mail.ru', 'bob123', 3);




--
-- Структура таблицы `category`
--

CREATE TABLE category (
	Id SERIAL PRIMARY KEY,
	Name varchar(30)
);

--
-- Дамп данных таблицы `category`
--

INSERT INTO category(Name) values 
('Sport'), ('Arcade'), ('Puzzle');




--
-- Структура таблицы `game`
--

CREATE TABLE game (
	Id SERIAL PRIMARY KEY,
	Name varchar(30),
	Raiting varchar(30),
	Annotation text,
	category_id int references "category"(Id) on update restrict on delete cascade
);

--
-- Дамп данных таблицы `game`
--

INSERT INTO game(Name, Raiting, category_id, Annotation) values
('football', '8', 1, 'This game is a regular ball simulator. The ball can be kicked all over the page up to certain boundaries until you get tired of doing it. All you have to do for this is to click on the button below.');

INSERT INTO game(Name, Raiting, category_id, Annotation) values
('snake', '7.5', 2, 'The player must control a long, thin creature resembling a snake, which crawls along the plane, collecting food, avoiding collisions with its own tail and the edges of the playing field. The more the snake eats, the more it becomes.');

INSERT INTO game(Name, Raiting, category_id, Annotation) values
('tetris', '9', 3, 'Random tetrimino figures fall from above into a rectangular glass. In flight, the player can turn the figure 90 degrees and move it along... Although, I think everyone is familiar with the rules of this game, so I see no reason to explain all this in detail.');

INSERT INTO game(Name, Raiting, category_id, Annotation) values
('minesweeper', '7.5', 3, 'A flat or voluminous playing field is divided into adjacent cells, some of which are mined, the number of mined cells is known. The goal of the game is to open all the cells that do not contain mines.');

INSERT INTO game(Name, Raiting, category_id, Annotation) values
('bomberman', '8.5', 2, 'The player controls a character in a maze consisting of destructible and indestructible walls. He can leave a bomb that explodes after a fixed amount of time and destroys walls next to it. The enemy is not present in the level.');

INSERT INTO game(Name, Raiting, category_id, Annotation) values
('breakout', '7', 2, 'At the beginning of this game there are eight lines of bricks, two lines of the same color. With a single ball, the player must knock as many bricks as possible, using the walls and / or the racket below to ricochet the ball into and destroy the bricks.');

INSERT INTO game(Name, Raiting, category_id, Annotation) values
('frogger', '7.5', 2, 'The aim of the game is to help the frog cross the game screen from the bottom to the top. The field of play is divided into 13 rows. The thirteenth row contains five cells. The frog must overcome the road and occupy all five cells by frogs in turn.');

INSERT INTO game(Name, Raiting, category_id, Annotation) values
('pong', '8', 1, 'Pong is a simple sports table tennis simulator. A small square, replacing a ping-pong ball, moves along the screen along a linear path. The gameplay consists of the players moving their rackets vertically to protect their goal.');




--
-- Структура таблицы `favorite_game`
--

CREATE TABLE favorite_game (
	game_id int references "game"(Id) on update restrict on delete cascade,
	users_id int references "users"(Id) on update restrict on delete cascade
);

--
-- Дамп данных таблицы `favorite_game`
--

INSERT INTO favorite_game(users_id, game_id) VALUES
(1, 1),
(1, 2),
(2, 5),
(3, 5),
(3, 1),
(3, 8);




































