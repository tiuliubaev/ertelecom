// .ui.xml template last modified: 1576648819317
package com.ertelecom.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class TasksTableWidget_ItemsTableBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.ertelecom.gwt.client.TasksTableWidget>, com.ertelecom.gwt.client.TasksTableWidget.ItemsTableBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.ertelecom.gwt.client.TasksTableWidget owner) {


    return new Widgets(owner).get_table();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final com.ertelecom.gwt.client.TasksTableWidget owner;


    public Widgets(final com.ertelecom.gwt.client.TasksTableWidget owner) {
      this.owner = owner;
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private com.ertelecom.gwt.client.TasksTableWidget_ItemsTableBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private com.ertelecom.gwt.client.TasksTableWidget_ItemsTableBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final com.ertelecom.gwt.client.TasksTableWidget_ItemsTableBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.ertelecom.gwt.client.TasksTableWidget_ItemsTableBinderImpl_GenBundle) GWT.create(com.ertelecom.gwt.client.TasksTableWidget_ItemsTableBinderImpl_GenBundle.class);
      // Setup section.

      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for table called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.cellview.client.CellTable get_table() {
      return build_table();
    }
    private com.google.gwt.user.cellview.client.CellTable build_table() {
      // Creation section.
      final com.google.gwt.user.cellview.client.CellTable table = (com.google.gwt.user.cellview.client.CellTable) GWT.create(com.google.gwt.user.cellview.client.CellTable.class);
      // Setup section.
      table.setWidth("100%");
      table.setPageSize(15);

      this.owner.table = table;

      return table;
    }
  }
}
