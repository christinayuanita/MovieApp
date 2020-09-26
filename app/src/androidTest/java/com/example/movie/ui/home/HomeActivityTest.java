package com.example.movie.ui.home;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.example.movie.R;
import com.example.movie.model.MovieEntity;
import com.example.movie.model.TVEntity;
import com.example.movie.utils.DataDummy;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasFocus;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParentIndex;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.*;

public class HomeActivityTest {

    private List<MovieEntity> dummyMovie = DataDummy.generateDummyMovies();
    private List<TVEntity> dummyTVShow = DataDummy.generateDummyTVShows();

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void loadMovie() {
        onView(allOf(withId(R.id.rv_movie), isDisplayed())).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.rv_movie), isDisplayed())).perform(RecyclerViewActions.scrollToPosition(dummyMovie.size()));
    }

    @Test
    public void loadTVShow() {
        onView(withText("TV Shows")).perform(click());
        onView(allOf(withId(R.id.rv_tvShow), isDisplayed())).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.rv_tvShow), isDisplayed())).perform(RecyclerViewActions.scrollToPosition(dummyTVShow.size()));
    }

    @Test
    public void loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.movie_title)).check(matches(isDisplayed()));
        onView(withId(R.id.movie_title)).check(matches(withText(dummyMovie.get(0).getMovieName())));
        onView(withId(R.id.movie_desc)).check(matches(isDisplayed()));
        onView(withId(R.id.movie_desc)).check(matches(withText(dummyMovie.get(0).getMovieDesc())));
        onView(withId(R.id.movie_genre)).check(matches(isDisplayed()));
        onView(withId(R.id.movie_genre)).check(matches(withText(dummyMovie.get(0).getMovieGenre())));
    }
}