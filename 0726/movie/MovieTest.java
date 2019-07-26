package edu.ssafy.movie;

import java.util.Scanner;

public class MovieTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		MovieMgr mm = MovieMgr.getInstance();
		
		mm.add(new Movie("괴물", "봉준호", 5, "스릴러", "재밌당"));
		mm.add(new Movie("기생충", "봉준호", 5, "스릴러,드라마", "재미있다"));
		mm.add(new Movie("7광구", "김지훈", 1, "SF", "재미없다"));
		
		int menu=0;
		
		while(true) {
			System.out.println("1. 영화 정보 입력");
			System.out.println("2. 영화 정보 전체 검색");
			System.out.println("3. 영화명 검색");
			System.out.println("4. 감독명 검색");
			System.out.println("5. 영화 장르별 검색");
			System.out.println("6. 영화 정보 삭제");
			System.out.println("0. 종료");
			System.out.println("원하시는 번호를 입력하세요.__");
			menu = sc.nextInt();
			
			if(menu==0)
				break;
			else {
				switch (menu) {
				case 1:
						System.out.println("[제목 감독명 점수 장르 한줄평]을 입력해주세요.");
						String title = sc.next();
						String director = sc.next();
						int grade = sc.nextInt();
						String genre = sc.next();
						String summary = sc.next();
						mm.add(new Movie(title, director, grade, genre, summary));
						System.out.println("영화 정보가 등록되었습니다.");
					break;
		
				case 2:
					//모든 영화정보 리턴
					Movie[] tmp = new Movie[mm.getSize()];
					tmp = mm.search();
					System.out.println("\n==========전체 영화 정보==========");
					for(int i=0; i<mm.getSize();i++) {
						System.out.println(tmp[i].toString());
					}
					break;
					
				case 3:
					//영화명 검색
					System.out.println("검색할 영화제목을 입력해주세요.");
					String input_title = sc.next();
					Movie[] tmp2 = new Movie[mm.getSize()];
					tmp2 = mm.search(input_title);
					for(int i=0; i<mm.getSize();i++) {
						if(tmp2[i]==null)
							break;
						else
							System.out.println(tmp2[i].toString());
					}
					break;
					
				case 4:
					//감독명 검색
					System.out.println("검색할 감독이름을 입력해주세요.");
					String input_director = sc.next();
					Movie[] tmp3 = new Movie[mm.getSize()];
					tmp3 = mm.searchDirector(input_director);
					for(int i=0; i<mm.getSize();i++) {
						if(tmp3[i]==null)
							break;
						else
							System.out.println(tmp3[i].toString());
					}
					break;
					
				case 5:
					//영화장르 검색
					System.out.println("검색할 영화장르를 입력해주세요.");
					String input_genre = sc.next();
					Movie[] tmp4 = new Movie[mm.getSize()];
					tmp4 = mm.searchGenre(input_genre);
					for(int i=0; i<mm.getSize();i++) {
						if(tmp4[i]==null)
							break;
						else
							System.out.println(tmp4[i].toString());
					}
					break;
				
				case 6:
					//영화정보 삭제
					System.out.println("삭제할 영화제목을 입력해주세요.");
					String input_title2 = sc.next();
					mm.delete(input_title2);
					System.out.println("영화가 삭제되었습니다.");
					break;
				}
			}
		System.out.println();
		}//end while
	}
}
