package com.thph.StyleGuideExample.impl;

import com.ur.style.URSpacingSize;
import com.ur.style.components.URButtons;
import com.ur.style.components.URDivider;
import com.ur.style.components.URDropdowns;
import com.ur.style.components.URErrorMessage;
import com.ur.style.components.URInformativeMessage;
import com.ur.style.components.URLoadingBar;
import com.ur.style.components.URSliders;
import com.ur.style.components.URSpacing;
import com.ur.style.components.URSuccessMessage;
import com.ur.style.components.URTables;
import com.ur.style.components.URTabs;
import com.ur.style.components.URTextFields;
import com.ur.style.components.URToggles;
import com.ur.style.components.URWarningMessage;
import com.ur.test.PreviewUI;
import com.ur.urcap.api.contribution.ContributionProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeView;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class ExampleProgramNodeView implements SwingProgramNodeView<ExampleProgramNodeContribution> {

	private URToggles toggleLib = new URToggles();
	private URButtons buttonLib = new URButtons();
	private URInformativeMessage informativeMessage = new URInformativeMessage();
	private URSuccessMessage successMessage = new URSuccessMessage();
	private URErrorMessage errorMessage = new URErrorMessage();
	private URWarningMessage warningMessage = new URWarningMessage();
	private URDivider divider = new URDivider();
	private URDropdowns dropdown = new URDropdowns();
	private URLoadingBar loadingbar = new URLoadingBar();
	private URSliders slider = new URSliders();
	private URTables tables = new URTables();
	private URTabs tabs = new URTabs();
	private URTextFields textFields = new URTextFields();

	private URSpacingSize urSpacingSize = new URSpacingSize();
	private URSpacing urSpacing = new URSpacing();

	public ExampleProgramNodeView() {

	}

	@Override
	public void buildUI(JPanel panel, ContributionProvider<ExampleProgramNodeContribution> provider) {
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
//		panel.add(showTextFields());
		panel.add(showTabs());
//		panel.add(showTables());
//		panel.add(showSlider());
//		panel.add(showLoadingBar());
//		panel.add(showDivider());
//		panel.add(showDifferentMessageType());
//		panel.add(showToggles());
//		panel.add(showButtons());

	}
	
	
	/**
	 * This main method to is used preview the programnode UI
	 * without having to deploy to the robot.
	 * To run, right-click on this class and run as java application.
	 * @param args
	 */
	public static void main(String args[]) {
		
		//Initialize the preview UI class.
		PreviewUI ui = new PreviewUI();
		
		//Initialize the program node panel.
		JPanel panel = ui.AddComponentsToUI("Example ProgramNode");
		
		//Adds UI component to the panel.
		panel.add(ui.showTextFields());
//		panel.add(ui.showTabs());
//		panel.add(ui.showTables());
//		panel.add(ui.showSlider());
//		panel.add(ui.showLoadingBar());
//		panel.add(ui.showDivider());
//		panel.add(ui.showDifferentMessageType());
//		panel.add(ui.showToggles());
//		panel.add(ui.showButtons());
		
		//adds the panel to be able to preview.
		ui.PreviewProgramNodeUI(panel);
		
		
	}

	private Box createTextFields() {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		JTextField fieldEnabled = textFields.getTextFieldEnabled(100);
		JTextField fieldDisabled = textFields.getTextFieldDisabled(100);

		fieldDisabled.setText("300");
		fieldEnabled.setText("300");

		box.add(fieldEnabled);
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(fieldDisabled);

		return box;

	}

	private Box showTabs() {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);

		JTabbedPane tabPane = tabs.getTabbedPane(100);
		tabPane.addTab("Command", new JPanel());
		tabPane.addTab("Graphics", new JPanel());
		tabPane.addTab("Variables", new JPanel());

		box.add(tabPane);

		return box;
	}
	
	

	private Box showTables() {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("test1");
		model.addRow(new String[] { "2018-02-06- 09:09:52.057 PolyScope        URSoftware 5.0.0" });
		model.addRow(new String[] { "2018-02-06- 09:09:52.057 PolyScope        Connected to Controller" });
		model.addRow(new String[] { "2018-02-06- 09:09:52.057 PolyScope        URSoftware 5.0.0 (26.10.2017)" });
		model.addRow(new String[] { "2018-02-06- 09:09:52.057 PolyScope        URSoftware 5.0.0 (26.10.2017)" });
		model.addRow(new String[] { "2018-02-06- 09:09:52.057 PolyScope        Safety checksum changed to: CCCC" });
		JTable table = tables.getTable();
		table.setModel(model);

		box.add(table);

		return box;
	}
	
	
	private Box showSlider() {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JSlider valueSlider = slider.getSlider(0, 99, 200);
		
		box.add(valueSlider);
		
		return box;
	}
	
	
	private Box showLoadingBar(){
		Box box = Box.createVerticalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JProgressBar thinLoadingbar = loadingbar.getThinLoadingBar(300);
		thinLoadingbar.setIndeterminate(true);
		thinLoadingbar.setMaximum(100);
		thinLoadingbar.setValue(50);
		thinLoadingbar.setIndeterminate(false);
		
		JProgressBar thickLoadingbar = loadingbar.getThickLoadingBar(300);
		thickLoadingbar.setIndeterminate(true);
		thickLoadingbar.setMaximum(100);
		thickLoadingbar.setValue(50);
		thickLoadingbar.setIndeterminate(false);
		
		JProgressBar thinLoadingbarWithText = loadingbar.getThinLoadingBarWithText(300, "12.00 mA");
		//thinLoadingbarWithText.setStringPainted(true);
		thinLoadingbarWithText.setIndeterminate(true);
		thinLoadingbarWithText.setMaximum(100);
		thinLoadingbarWithText.setValue(50);
		thinLoadingbarWithText.setIndeterminate(false);
		
		box.add(thinLoadingbar);
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(thinLoadingbarWithText);
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(thickLoadingbar);
		
		return box;
	}
	
	private Box showDropdowns() {
		Box box = Box.createVerticalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		String[] stringValues = {"A","B","C"};
		
		JComboBox<String> boxEnabled = dropdown.getDropDownEnabled(100);
		boxEnabled.setModel(new DefaultComboBoxModel<String>(stringValues));
		
		JComboBox<String> boxDisabled = dropdown.getDropDownDisabled(100);
		boxDisabled.setModel(new DefaultComboBoxModel<String>(stringValues));
		
		box.add(boxEnabled);
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(boxDisabled);
		
		return box;
	}
	
	
	private Box showDivider() {
		Box box = Box.createVerticalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		box.add(divider.getVerticalDivider(100));
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(divider.getHorizontalDivider(100));
		
		
		return box;
	}
	
	
	
	private Box showDifferentMessageType() {
		
		Box box = Box.createVerticalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		box.add(informativeMessage.getLargeInformativeMessage("INFO MESSAGE", 600));
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(informativeMessage.getSmallInformativeMessage("Changes do not take effect until saving the installation", 600));
		
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		
		box.add(successMessage.getLargeSuccessMessage("SUCCESS MESSAGE", 600));
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(successMessage.getSmallSuccessMessage("Success Message", 600));
		
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		
		box.add(errorMessage.getLargeErrorMessage("NO CONTROLLER", 600));
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(errorMessage.getSmallErrorMessage("Error Message", 600));
		
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		
		box.add(warningMessage.getLargeWarningMessage("BACKDRIVE", 600));
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(warningMessage.getSmallWarningMessage("Warning Message", 600));
		
		return box;
		
	}

	private Box showToggles() {
		
		Box box = Box.createVerticalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		box.add(toggleLib.getLargeToggleEnabled("Enable", 200));
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(toggleLib.getLargeToggleDisabled("Disable", 200));

		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));

		JToggleButton toggle = toggleLib.getSmallToggleSelected(50);

		box.add(toggle);
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(toggleLib.getSmallToggleDeselected(50));
		
		return box;
	}

	private Box showButtons() {
		
		Box box = Box.createVerticalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);

		box.add(buttonLib.getLargeButtonDisabled("MyLarge", 200));
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(buttonLib.getLargeButtonEnabled("MyCTAButtonMedium", 200));

		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));

		box.add(buttonLib.getSmallButtonEnabled("MySmallButtonMedium", 200));
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(buttonLib.getSmallButtonDisabled("MySmallButtonMedium", 200));

		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));

		box.add(buttonLib.getMediumCTAButtonDisabled("MyCTAButtonMedium", 200));
		box.add(urSpacing.createVerticalSpacing(urSpacingSize.VERTICAL_SPACING));
		box.add(buttonLib.getSmallCTAButtonEnabled("MyCTAButtonMedium", 200));
		
		
		return box;

	}


}