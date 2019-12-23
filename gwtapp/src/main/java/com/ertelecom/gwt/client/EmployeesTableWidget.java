package com.ertelecom.gwt.client;

import com.ertelecom.gwt.common.EmployeeDto;
import com.ertelecom.gwt.common.TaskDto;
import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.ArrayList;
import java.util.List;

public class EmployeesTableWidget extends Composite {

    @UiField
    CellTable<EmployeeDto> table;

    private EmployeesClient client;

    @UiTemplate("EmployeesTable.ui.xml")
    interface ItemsTableBinder extends UiBinder<Widget, EmployeesTableWidget> {
    }

    private static EmployeesTableWidget.ItemsTableBinder uiBinder = GWT.create(EmployeesTableWidget.ItemsTableBinder.class);

    public EmployeesTableWidget() {
        initWidget(uiBinder.createAndBindUi(this));

        TextColumn<EmployeeDto> idColumn = new TextColumn<EmployeeDto>() {
            @Override
            public String getValue(EmployeeDto employeeDto) {
                return employeeDto.getId().toString();
            }
        };
        table.addColumn(idColumn, "ID");

        TextColumn<EmployeeDto> titleColumn = new TextColumn<EmployeeDto>() {
            @Override
            public String getValue(EmployeeDto employeeDto) {
                return employeeDto.getLast_name() + ' ' + employeeDto.getFst_name() + ' ' + employeeDto.getMid_name();
            }
        };
        table.addColumn(titleColumn, "FIO");

        TextColumn<EmployeeDto> statusColumn = new TextColumn<EmployeeDto>() {
            @Override
            public String getValue(EmployeeDto employeeDto) {
                return employeeDto.getJob_title();
            }
        };
        table.addColumn(statusColumn, "Job title");

        TextColumn<EmployeeDto> executorColumn = new TextColumn<EmployeeDto>() {
            @Override
            public String getValue(EmployeeDto employeeDto) {
                return employeeDto.getWork_ph_num();
            }
        };
        table.addColumn(executorColumn, "Work phone");

        client = GWT.create(EmployeesClient.class);
        Column<EmployeeDto, EmployeeDto> actionColumn = new Column<EmployeeDto, EmployeeDto>(
                new ActionCell<EmployeeDto>("REMOVE", new ActionCell.Delegate<EmployeeDto>() {
                    @Override
                    public void execute(EmployeeDto employeeDto) {
                        String token = Storage.getLocalStorageIfSupported().getItem("jwt");
                        GWT.log("STORAGE: " + token);
                        client.removeEmployee(token, employeeDto.getId().toString(), new MethodCallback<Void>() {
                            @Override
                            public void onFailure(Method method, Throwable throwable) {
                                GWT.log(throwable.toString());
                                GWT.log(throwable.getMessage());
                                GWT.log("Status code: " + method.getResponse().getStatusCode());
                            }

                            @Override
                            public void onSuccess(Method method, Void result) {
                                GWT.log("Status code: " + method.getResponse().getStatusCode());
                                refresh();
                            }
                        });
                    }
                })) {
            @Override
            public EmployeeDto getValue(EmployeeDto employeeDto) {
                return employeeDto;
            }

        };
        table.addColumn(actionColumn, "Actions");
        table.setColumnWidth(idColumn, 100, Style.Unit.PX);
        table.setColumnWidth(titleColumn, 400, Style.Unit.PX);
        table.setColumnWidth(actionColumn, 200, Style.Unit.PX);
    }

    public void refresh() {
        String token = Storage.getLocalStorageIfSupported().getItem("jwt");
        GWT.log("STORAGE: " + token);
        client.refresh(token, new MethodCallback<List<EmployeeDto>>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                GWT.log(throwable.toString());
                GWT.log(throwable.getMessage());
                GWT.log("Status code: " + method.getResponse().getStatusCode());
//                Window.alert("Невозможно получить список employees: Сервер не отвечает");
            }

            @Override
            public void onSuccess(Method method, List<EmployeeDto> i) {
                GWT.log("Received " + i.size() + " items");
                GWT.log("Status code: " + method.getResponse().getStatusCode());
                List<EmployeeDto> employees = new ArrayList<>();
                employees.addAll(i);
                table.setRowData(employees);
            }
        });
    }

    public void update(String last_name, String fst_name) {
        String token = Storage.getLocalStorageIfSupported().getItem("jwt");
        GWT.log("STORAGE: " + token);
        client.getAllEmployees(token, last_name, fst_name, new MethodCallback<List<EmployeeDto>>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                GWT.log(throwable.toString());
                GWT.log(throwable.getMessage());
                GWT.log("Status code: " + method.getResponse().getStatusCode());
                Window.alert("Невозможно получить список employees: Сервер не отвечает");
            }

            @Override
            public void onSuccess(Method method, List<EmployeeDto> i) {
                GWT.log("Received " + i.size() + " items");
                GWT.log("Status code: " + method.getResponse().getStatusCode());
                List<EmployeeDto> employees = new ArrayList<>();
                employees.addAll(i);
                table.setRowData(employees);
            }
        });
    }

    public void save(EmployeeDto employeeDto) {
        String token = Storage.getLocalStorageIfSupported().getItem("jwt");
        GWT.log("STORAGE: " + token);
        client.saveEmployee(token, employeeDto, new MethodCallback<List<EmployeeDto>>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                GWT.log(throwable.toString());
                GWT.log(throwable.getMessage());
                GWT.log("Status code: " + method.getResponse().getStatusCode());
                Window.alert("Невозможно получить список employees: Сервер не отвечает");
            }

            @Override
            public void onSuccess(Method method, List<EmployeeDto> i) {
                refresh();
            }
        });
    }
}
