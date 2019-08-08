package com.ssafy.java;

import java.util.List;

public interface INewsDAO {
	abstract List<News> getNewsList(String url);
	News search(int index);
}
