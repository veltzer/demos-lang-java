package com.company;

public class Maze {

    private static char maze[][] = {
            {' ', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
            {'*', ' ', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
            {'*', ' ', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
            {'*', ' ', '*', '*', '*', '*', '*', ' ', ' ', ' ', ' ', '*', '*', '*', '*', '*', '*', '*', '*', '*', ' ', '*', '*', '*', '*'},
            {'*', ' ', ' ', ' ', ' ', '*', '*', ' ', '*', '*', ' ', ' ', ' ', ' ', '*', '*', '*', '*', '*', '*', ' ', '*', '*', '*', '*'},
            {'*', ' ', '*', '*', ' ', ' ', ' ', ' ', '*', '*', '*', '*', '*', ' ', '*', '*', '*', '*', '*', '*', ' ', '*', '*', '*', '*'},
            {'*', ' ', '*', '*', '*', '*', '*', ' ', '*', '*', '*', '*', '*', ' ', '*', '*', '*', ' ', ' ', ' ', ' ', ' ', '*', '*', '*'},
            {'*', ' ', '*', '*', '*', '*', '*', ' ', '*', '*', '*', '*', '*', ' ', ' ', '*', '*', ' ', '*', '*', '*', ' ', '*', '*', '*'},
            {'*', ' ', '*', '*', '*', '*', '*', ' ', ' ', ' ', '*', '*', '*', '*', ' ', ' ', ' ', ' ', '*', '*', '*', ' ', ' ', ' ', '*'},
            {'*', '*', '*', '*', '*', '*', '*', '*', '*', ' ', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', ' ', '*'},
            {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', ' ', '*'},
            {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', ' ', '*'}
    };
    int size_x, size_y, fx, fy, path_pos;
    int[][] path;
    public Maze(int ifx, int ify) {
        size_x=maze[0].length;
        size_y=maze.length;
        fx=ifx;
        fy=ify;
        path=new int[size_x*size_y][2];
        path_pos=0;
    }

    void print_path() {
        for(int i=path_pos-1;i>=0;i--) {
            System.out.println("x,y is "+path[i][0]+" "+path[i][1]);
        }
    }

    void add_to_path(int x, int y) {
        path[path_pos][0]=x;
        path[path_pos][1]=y;
        path_pos++;
    }

    boolean check_and_add_to_path(int gx, int gy) {
        /* check if:
            gx, gy are still on the grid -> done
            gx, gy is not a wall -> done
            gx, gy were not visited -> done
            if all is well, visit gx,gy -> done
            add to path
            and call solve recursively
         */
        if(gx<0 || gx>=size_x || gy<0 || gy>=size_y) {
            return false;
        }
        if(maze[gy][gx]=='*') {
            return false;
        }
        if(maze[gy][gx]=='v') {
            return false;
        }
        maze[gy][gx]='v';
        if (solve(gx,gy)) {
            add_to_path(gx, gy);
            return true;
        }
        return false;
    }

    boolean solve(int sx, int sy) {
        /* Did we reach the destination? */
        if(sx==fx && sy==fy) {
            return true;
        }
        if(check_and_add_to_path(sx+1, sy)) {
            return true;
        }
        if(check_and_add_to_path(sx-1, sy)) {
            return true;
        }
        if(check_and_add_to_path(sx, sy+1)) {
            return true;
        }
        if(check_and_add_to_path(sx, sy-1)) {
            return true;
        }
        maze[sy][sx]=' ';
        return false;
    }

    public static void main(String[] args) {
        Maze m = new Maze(23, 11);
        if(m.solve(1, 1)==false) {
            System.out.println("Cant solve");
        } else {
            m.print_path();
        }
    }
}
