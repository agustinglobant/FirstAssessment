package co.mobilemakers.firstassessment;

/**
 * Created by agustin.gugliotta on 09/02/2015.
 */
public interface Changeable {
    public void addMarkdown(String mdown);

    public void cleanMarkdown();

    public String getMarkdown();

    public void updateView();
}
