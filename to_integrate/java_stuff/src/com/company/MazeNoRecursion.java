package com.company;

public class MazeNoRecursion {

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
    public MazeNoRecursion(int ifx, int ify) {
        size_x=maze[0].length;
        size_y=maze.length;
        fx=ifx;
        fy=ify;
        path=new int[size_x*size_y][2];
        path_pos=0;
    }

    void print_path() {
        for(int i=0;i<path_pos;i++) {
            System.out.println("x,y is "+path[i][0]+" "+path[i][1]);
        }
        /*
        for(int i=path_pos-1;i>=0;i--) {
            System.out.print("("+path[i][0]+","+path[i][1]+") ");
        }
        */
        System.out.println();
    }

    void add_to_path(int x, int y) {
        path[path_pos][0]=x;
        path[path_pos][1]=y;
        path_pos++;
    }

    boolean go_to(int gx, int gy) {
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
        add_to_path(gx, gy);
        return true;
    }

    boolean solve(int sx, int sy) {
        add_to_path(sx, sy);
        while(sx!=fx || sy!=fy) {
            // System.out.println("sx is "+sx+", and sy is "+sy);
            // print_path();
            if(go_to(sx+1, sy)) {
                sx++;
                continue;
            }
            if(go_to(sx-1,sy)) {
                sx--;
                continue;
            }
            if(go_to(sx, sy-1)) {
                sy--;
                continue;
            }
            if(go_to(sx, sy+1)) {
                sy++;
                continue;
            }
            if(path_pos==0) {
                return false;
            } else {
                path_pos--;
                sx = path[path_pos][0];
                sy = path[path_pos][1];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MazeNoRecursion m = new MazeNoRecursion(23, 11);
        if(m.solve(1, 1)==false) {
            System.out.println("Cant solve");
        } else {
            m.print_path();
        }
    }
}
