package com.test.maru;

import com.test.maru.api.ReunionApiService;
import com.test.maru.di.DI;
import com.test.maru.model.Reunion;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static com.test.maru.api.ReunionList.REUNION;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(JUnit4.class)
public class ExampleUnitTest {

    private ReunionApiService mReunionApiService;

    @Before
    public void setup() {
        mReunionApiService = DI.getService();
    }


    @Test
    public void getReunion() {

        List<Reunion> reunions = mReunionApiService.getReunions();
        List<Reunion> reunionList = REUNION;
        assertThat(reunions,containsInAnyOrder(reunionList.toArray()));

    }

    @Test
    public void deleteReunion() {
        Reunion reunion = mReunionApiService.getReunions().get(0);
        mReunionApiService.deleteReunion(reunion);
        assertFalse(mReunionApiService.getReunions().contains(reunion));
    }



}