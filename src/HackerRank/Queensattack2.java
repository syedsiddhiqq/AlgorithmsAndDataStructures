//package HackerRank;
//
//import java.util.Scanner;
//
//
//
//AtomicReference<String> purchaseType = new AtomicReference<>();
//
//scComponents.stream().filter(scComponent -> "LM".equals(scComponent.getComponentName()))
//        .flatMap(scComponent -> scComponent.getScComponentAttributes().stream())
//        .filter(scComponentAttribute -> "Media Gateway Purchase Type"
//                .equals(scComponentAttribute.getAttributeName())).findAny()
//        .ifPresent(scComponentAttribute -> {
//            purchaseType.set(scComponentAttribute.getAttributeValue());
//        });
//
//
//
///**
// * @author Syed Ali.
// * @createdAt 19/12/2020, Saturday, 10:39
// * https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem
// */
//public class Queensattack2 {
//
//	public static void main(String[] args) {
//		int n,k;
//		Scanner scanner = new Scanner(System.in);
////		std::cin>>n>>k;
//		n = scanner.nextInt();
//		k = scanner.nextInt();
////		int chessBoard[200000][200000];
//		// Queens row and col
//		long[][] chessBoard = new long[n][n];
//
//
//		int qrow,qcol,obstacleRow,obstacleCol,attackingSquares=0;
////		std::cin>>qrow>>qcol;
//		qrow = scanner.nextInt();
//		qcol = scanner.nextInt();
//
//		for(int i=1;i<=n;i++){
//			for(int j=1;j<=n;j++){
//				chessBoard[i][j] = 0;
//			}
//		}
//
//		for(int i = 1; i<=k; i++){
////			std::cin>>obstacleRow>>obstacleCol;
//
//			obstacleRow = scanner.nextInt();
//			obstacleCol = scanner.nextInt();
//			// 1 --> denotes obstacles.
//			chessBoard[obstacleRow][obstacleCol] = 1;
//		}
//
//		int tempRow,tempCol;
//		tempRow = qrow;
//		tempCol = qcol;
//
//		// Up from queens
//		tempRow = qrow-1;
//		tempCol = qcol;
//		while(tempRow>=1 && chessBoard[tempRow][tempCol] != 1){
//			attackingSquares++;
//			tempRow--;
//		}
//		// std::cout<<"After UP:"<<attackingSquares<<std::endl;
//
//		// down from queens
//		tempRow = qrow+1;
//		tempCol = qcol;
//		while(tempRow<=n && chessBoard[tempRow][tempCol] != 1){
//			attackingSquares++;
//			tempRow++;
//		}
//		// std::cout<<"After down:"<<attackingSquares<<std::endl;
//
//		// left from queens
//		tempRow = qrow;
//		tempCol = qcol-1;
//		while(tempCol>=1 && chessBoard[tempRow][tempCol] != 1){
//			attackingSquares++;
//			tempCol--;
//		}
//		// std::cout<<"After left:"<<attackingSquares<<std::endl;
//
//		// right from queens
//		tempRow = qrow;
//		tempCol = qcol+1;
//		while(tempCol<=n && chessBoard[tempRow][tempCol] != 1){
//			attackingSquares++;
//			tempCol++;
//		}
//		// std::cout<<"After right:"<<attackingSquares<<std::endl;
//
//		// upper left
//		tempRow = qrow-1;
//		tempCol = qcol-1;
//		while(tempCol>=1 && tempRow >=1 && chessBoard[tempRow][tempCol] != 1){
//			attackingSquares++;
//			tempCol--;
//			tempRow--;
//		}
//		// std::cout<<"After UP left:"<<attackingSquares<<std::endl;
//
//		// upper right
//		tempRow = qrow-1;
//		tempCol = qcol+1;
//		while(tempCol<=n && tempRow >=1 && chessBoard[tempRow][tempCol] != 1){
//			attackingSquares++;
//			tempCol++;
//			tempRow--;
//		}
//		// std::cout<<"After UP right:"<<attackingSquares<<std::endl;
//
//		// lower right
//		tempRow = qrow+1;
//		tempCol = qcol+1;
//		while(tempCol<=n && tempRow <=n && chessBoard[tempRow][tempCol] != 1){
//			attackingSquares++;
//			tempCol++;
//			tempRow++;
//		}
//		// std::cout<<"After lower right:"<<attackingSquares<<std::endl;
//
//		// lower left
//		tempRow = qrow+1;
//		tempCol = qcol-1;
//		while(tempCol>=1 && tempRow <=n && chessBoard[tempRow][tempCol] != 1){
//			attackingSquares++;
//			tempCol--;
//			tempRow++;
//		}
//		// std::cout<<"After lower left:"<<attackingSquares<<std::endl;
//
////		std::cout<<attackingSquares;
//		System.out.println(attackingSquares);
//	}
//
//
//}
