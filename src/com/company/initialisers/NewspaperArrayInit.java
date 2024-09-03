package com.company.initialisers;

import com.company.interfaces.NewspaperInitialiser;
import com.company.models.Newspaper;

import java.util.Random;

public class NewspaperArrayInit implements NewspaperInitialiser {
    private static final String[] newspaperNames = {"Daily News", "Morning Star", "Evening Update"};
    private static final String[] headlines = {"Local Hero Saves Cat", "New Park Opens Downtown", "City Plans New Metro Line"};
    private static final Random random = new Random();

    @Override
    public void initialise(Newspaper newspaper) {
        if (newspaper == null) {
            System.out.println("Newspaper object is null.");
            return;
        }
        String name = newspaperNames[random.nextInt(newspaperNames.length)];
        String dateIssue = "201" + random.nextInt(10) + "-0" + (1 + random.nextInt(9)) + "-0" + (1 + random.nextInt(9));
        String[] selectedHeadlines = new String[]{headlines[random.nextInt(headlines.length)]};

        newspaper.setName(name);
        newspaper.setDateIssue(dateIssue);
        newspaper.setHeadlines(selectedHeadlines);
    }

}

