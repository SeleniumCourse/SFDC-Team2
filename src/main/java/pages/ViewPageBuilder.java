package pages;

/**
 * Created by Mario Perez on 6/10/2015.
 */
public class ViewPageBuilder {

    private String viewName, viewUniqueName;
    private String [][] filterAdditionalFields;
    private String [] availableFields;
    private boolean visibleToMe, visibleAllUsers, visibleGroupUsers, filterByOwnerMyView, filterByOwnerAllViews;

    public ViewPageBuilder(String viewName, String viewUniqueName) {
        this.viewName = viewName;
        this.viewUniqueName = viewUniqueName;

    }

    public ViewPageBuilder setfilterByAdditionalField(String [][] filterAdditionalFields) {
        this.filterAdditionalFields = filterAdditionalFields;
        return this;
    }

    public ViewPageBuilder setAvailableFields(String [] availableFields) {
        this.availableFields = availableFields;
        return this;
    }

    public ViewPageBuilder setFilterByOwnerMyViewRadioBtn(Boolean filterByOwnerMyView) {
        this.filterByOwnerMyView = filterByOwnerMyView;
        return this;
    }

    public ViewPageBuilder setFilterByOwnerAllViewsRadioBtn(Boolean filterByOwnerAllViews) {
        this.filterByOwnerAllViews = filterByOwnerAllViews;
        return this;
    }

    public ViewPageBuilder setVisibleAllUsersRadioBtn(Boolean visibleAllUsers) {
        this.visibleAllUsers = visibleAllUsers;
        return this;
    }

    public ViewPageBuilder setVisibleCertainGroupsRadioBtn(Boolean visibleGroupUsers) {
        this.visibleGroupUsers = visibleGroupUsers;
        return this;
    }

    public ViewPageBuilder setVisibleOnlyToMeRadioBtn(Boolean visibleToMe) {
        this.visibleToMe = visibleToMe;
        return this;
    }

    public String getViewName() {
        return viewName;
    }

    public String getUniqueName() {
        return viewUniqueName;
    }

    public String [][] getFilterByAdditionalField() {
        return filterAdditionalFields;
    }

    public String [] getAvailableFields() {
        return availableFields;
    }

    public Boolean getVisibleToMe() {
        return visibleToMe;
    }

    public Boolean getVisibleAllUsers() {
        return visibleAllUsers;
    }

    public Boolean getVisibleGroupUsers() {
        return visibleGroupUsers;
    }

    public Boolean getFilterByOwnerMyViewRadioBtn() {
        return filterByOwnerMyView;
    }

    public Boolean getFilterByOwnerAllViewsRadioBtn() {
        return filterByOwnerAllViews;
    }





    public ViewPage build() {
        return new ViewPage(this);
    }
}
