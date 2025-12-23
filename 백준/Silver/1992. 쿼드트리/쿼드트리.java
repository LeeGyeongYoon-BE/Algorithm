import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] quadTree;
    static void cut(int i, int j, int size){
        if( size == 1 ){
            System.out.print( quadTree[i][j] );
            return;
        }

        for( int row = i; row < i + size; row++ ){
            for(int col = j; col < j + size; col++){

                if( quadTree[i][j] != quadTree[row][col] ){
                    System.out.print( "(" );

                    cut(i,			j,			size/2);
                    cut(i,			j + size/2,	size/2);
                    cut(i + size/2,	j,			size/2);
                    cut(i + size/2,	j + size/2,	size/2);

                    System.out.print( ")" );
                    return;
                } // if
            } // for
        } // for

        System.out.print( quadTree[i][j] );
    } // cut

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        quadTree = new char[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            quadTree[i] = st.nextToken().toCharArray();
        } // for

        cut(0, 0, N); // int i, int j, int size
        System.out.println();
        br.close();
    } // main
} // class
