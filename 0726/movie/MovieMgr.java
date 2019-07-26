package edu.ssafy.movie;

public class MovieMgr {
	
	private Movie[] movies = new Movie[100];
	private int index=0;

	//singleton pattern
	private static MovieMgr mm = new MovieMgr();
	public static MovieMgr getInstance() {
		return mm;
	}

	
	//파라미터로 전달된 영화 정보를 전달받아 배열에 저장
	public void add(Movie m) {
		movies[index] = m;
		index++;
	}
	
	
	//배열에 저장된 모든 영화정보 출력
	public Movie[] search() {
		Movie[] tmp = new Movie[index];
		for(int i=0; i<index; i++) {
			tmp[i] = movies[i];
		}
		return tmp;
	}
	
	
	//파라미터로 전달된 타이틀을 포함한 모든 영화정보 리턴
	public Movie[] search(String title) {
		Movie[] tmp = new Movie[index];
		for(int i=0; i<index; i++) {
			if(movies[i].title.contains(title))
				tmp[i] = movies[i];
		}
		return tmp;
	}
	
	
	//파라미터로 전달된 감독명의 영화정보 리턴
	public Movie[] searchDirector(String name) {
		Movie[] tmp = new Movie[index];
		for(int i=0; i<index; i++) {
			if(movies[i].director.contains(name))
				tmp[i] = movies[i];
		}
		return tmp;
	}
	
	
	//파라미터로 전달된 장르의 영화정보 리턴
	public Movie[] searchGenre(String genre) {
		Movie[] tmp = new Movie[index];
		for(int i=0; i<index; i++) {
			if(movies[i].genre.contains(genre))
				tmp[i] = movies[i];
		}
		return tmp;
	}
	
	
	//파라미터로 전달된 제목의 영화 삭제
	public void delete(String title) {
		for(int i=0; i<index; i++) {
			if(movies[i].title.equals(title))
				remove_movie(i);
		}
	}
	
	//저장된 영화 정보 갯수 리턴
	public int getSize() {
		return index;
	}

	// 입력된 영화제목을 삭제하기 위한 메소드
	private void remove_movie(int idx) {
		movies[idx]=movies[index-1];
		index--;
	}
	
	
	
}
