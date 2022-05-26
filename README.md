# game-of-life-tdd
Developing game of life project using test driven development approach

# Final result after testing Cell class with CellTest
We followed rules based on [Wikipedia](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)
<br>
After completing each rule for **Cell** class we wrote methods for testing depicted below
<br>
We followed **Red Green Refactor** pattern while testing our project
<br>

![image](https://user-images.githubusercontent.com/70511142/170345387-0c20dbac-5656-4163-9485-4374e128cead.png)

# Final result after testing Coordinate class with CoordinateTest
<br>
By following the rules we wrote test cases for testing coordinates, there includes
<br>
- Get neighbors for the first cell <br>
- Get neighbors for the last cell <br>
- Get neighbors for any other cells <br>
<br>

![image](https://user-images.githubusercontent.com/70511142/170463817-e06c054b-d4a9-42bf-9986-ad8c3d8a8830.png)

# Final result after testing Grid class with GridTest

We have tested several cases if we have implemented the logic correctly or not
<br>
- Does 2D array correctly passes to the grid <br>
- Get all alive cells on the grid <br>
- Count of alive neighbors for a cell <br>
- Is next generation working correctly <br>
- Is there alive cells on the edge of grid <br>
<br>

![image](https://user-images.githubusercontent.com/70511142/170470247-799b34ce-64ef-4a09-aada-4a5b9a24c3f6.png)

# After completing testing the project we can visualize our game as follow
The next generation will be wrote to ```output.txt``` file
![image](https://user-images.githubusercontent.com/70511142/170475902-8f91d5eb-5681-4531-b7c0-9592a9114127.png)




