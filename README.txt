Игра - "Змейка"

Запуск с консоли
Необходимо запустить файл SnakeGame.jar.

Чтобы запустить файл SnakeGame.jar, необходимо:
	- запустить jdk-19_windows-x64_bin.exe -> выполнить установку
	- запустить командную строку
		- для Windows
			- win + R
			- в окне набрать cmd -> OK
	-  в командной строке набрать команду - (команда означает, что мы переходим в папку с файлом):
		- cd путь до папки, где лежит файл SnakeGame.jar
		- например: 
			- cd C:\Users\Viktor\Downloads\Files (Нажать Enter)
		
	- запустить игру:
		- в командной строке набираем команду:
			- java --module-path "путь до папки javafx-sdk-19.0.2.1\lib" (путь указывается до папки lib(!)) --add-modules=javafx.controls,javafx.fxml,javafx.base,javafx.graphics -jar SnakeGame.jar
			Например:
			- java --module-path "C:\Users\Viktor\Java Programs\Snake\SnakeGame(common project)\SnakeGame_Common project\javafx-sdk-19.0.2.1\lib" --add-modules=javafx.controls,javafx.fxml,javafx.base,javafx.graphics -jar SnakeGame.jar (нажать Enter)
	- наслаждаться файлом
