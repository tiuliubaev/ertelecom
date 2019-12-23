package com.ertelecom.gwt.client;

import com.ertelecom.gwt.common.EmployeeDto;
import com.ertelecom.gwt.common.StatusDto;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.security.Principal;
import java.util.List;

public class UserInfoWidget  extends Composite {
    @UiField
    FormPanel form2;

    @UiField
    TextBox userInfo;

    private TasksTableWidget tasksTableWidget;

    @UiTemplate("UserInfo.ui.xml")
    interface AddItemFormBinder extends UiBinder<Widget, UserInfoWidget> {
    }

    private static UserInfoWidget.AddItemFormBinder uiBinder = GWT.create(UserInfoWidget.AddItemFormBinder.class);

    public UserInfoWidget() {
        this.initWidget(uiBinder.createAndBindUi(this));

        userInfo.setReadOnly(true);

    }

    @UiHandler("form2")
    public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
        Window.alert(event.getResults());
        tasksTableWidget.refresh();
    }


}
