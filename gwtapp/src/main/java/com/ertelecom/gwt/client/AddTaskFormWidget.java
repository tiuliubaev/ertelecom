package com.ertelecom.gwt.client;

import com.ertelecom.gwt.common.EmployeeDto;
import com.ertelecom.gwt.common.StatusDto;
import com.ertelecom.gwt.common.TaskDto;
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

public class AddTaskFormWidget extends Composite {

    @UiField
    FormPanel form1;

    @UiField
    TextBox idText;

    @UiField
    TextBox titleText;

    @UiField
    ListBox statusText;

    @UiField
    ListBox executorText;

    @UiField
    ListBox ownerText;

    @UiField
    TextBox descText;

    private TasksTableWidget tasksTableWidget;

    @UiTemplate("AddTaskForm.ui.xml")
    interface AddItemFormBinder extends UiBinder<Widget, AddTaskFormWidget> {
    }

    private static AddTaskFormWidget.AddItemFormBinder uiBinder = GWT.create(AddTaskFormWidget.AddItemFormBinder.class);

    public AddTaskFormWidget(TasksTableWidget tasksTableWidget) {
        this.initWidget(uiBinder.createAndBindUi(this));
        this.form1.setAction(Defaults.getServiceRoot().concat("tasks"));
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
                for (EmployeeDto executor : executorsList) {
                    executorText.addItem(executor.getLast_name(), String.valueOf(executor.getId()));
                }
            }
        });

//  Владельцы
        TasksClient owners = GWT.create(TasksClient.class);
        owners.getAllOwners(token, new MethodCallback<List<EmployeeDto>>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                GWT.log(throwable.toString());
                GWT.log(throwable.getMessage());
                Window.alert("Невозможно получить список исполнителей");
            }

            @Override
            public void onSuccess(Method method, List<EmployeeDto> ownersList) {
                for (EmployeeDto executor : ownersList) {
                    ownerText.addItem(executor.getLast_name(), String.valueOf(executor.getId()));
                }
            }
        });

    }

    @UiHandler("form1")
    public void onSubmit(FormPanel.SubmitEvent event) {
        if (idText.getText().length() == 0) {
            Window.alert("Необходимо заполнить поле ID");
            event.cancel();
        }

        if (titleText.getValue().length() < 5) {
            Window.alert("Название задачи должно быть не менее 5 символов");
            event.cancel();
        }
    }

    @UiHandler("form1")
    public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
        TaskDto taskDto = new TaskDto(Long.valueOf(idText.getValue()), titleText.getValue(), new EmployeeDto(Long.valueOf(ownerText.getSelectedValue())), new EmployeeDto(Long.valueOf(executorText.getSelectedValue())), descText.getValue(), statusText.getSelectedValue());
        tasksTableWidget.save(taskDto);
        tasksTableWidget.refresh();
    }

    @UiHandler("btnSubmit")
    public void submitClick(ClickEvent event) {
        form1.submit();
    }
}
