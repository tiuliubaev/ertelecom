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

import java.util.List;

public class FindTaskFormWidget extends Composite {
    @UiField
    FormPanel form;
//    @UiField
//    TextBox idText;

    @UiField
    ListBox statusText;

    @UiField
    ListBox executorText;

    private TasksTableWidget tasksTableWidget;

    @UiTemplate("FindTaskForm.ui.xml")
    interface AddItemFormBinder extends UiBinder<Widget, FindTaskFormWidget> {
    }

    private static FindTaskFormWidget.AddItemFormBinder uiBinder = GWT.create(FindTaskFormWidget.AddItemFormBinder.class);

    public FindTaskFormWidget(TasksTableWidget tasksTableWidget) {
        this.initWidget(uiBinder.createAndBindUi(this));
        this.form.setAction(Defaults.getServiceRoot().concat("tasks"));
        this.tasksTableWidget = tasksTableWidget;

//  Статусы
        TasksClient taskStatus = GWT.create(TasksClient.class);

        String token = Storage.getLocalStorageIfSupported().getItem("jwt");
        GWT.log("STORAGE: " + token);
        taskStatus.getAllStatus(token, new MethodCallback<List<StatusDto>>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                GWT.log(throwable.toString());
                GWT.log(throwable.getMessage());
                Window.alert("Невозможно получить список статусов");
            }

            @Override
            public void onSuccess(Method method, List<StatusDto> taskStatusList) {
                statusText.addItem("All", "");
                for (StatusDto taskStatus0 : taskStatusList) {
                    statusText.addItem(taskStatus0.getText());
                }
            }
        });

//  Исполнители
        TasksClient executors = GWT.create(TasksClient.class);

        executors.getAllExecutors(token, new MethodCallback<List<EmployeeDto>>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                GWT.log(throwable.toString());
                GWT.log(throwable.getMessage());
                Window.alert("Невозможно получить список исполнителей");
            }

            @Override
            public void onSuccess(Method method, List<EmployeeDto> executorsList) {
                executorText.addItem("All", "");
                for (EmployeeDto executor : executorsList) {
                    executorText.addItem(executor.getLast_name(), String.valueOf(executor.getId()));
                }
            }
        });
    }

    @UiHandler("form")
    public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
        Window.alert(event.getResults());
        tasksTableWidget.refresh();
    }

    @UiHandler("btnSubmit")
    public void submitClick(ClickEvent event) {
        tasksTableWidget.update(this.statusText.getSelectedValue(), this.executorText.getSelectedValue());

    }
}
