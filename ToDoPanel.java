import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoPanel extends JPanel {
    private DefaultListModel<Task> taskListModel;
    private JList<Task> taskList;
    private JTextField taskInputField;
    private JButton addButton, removeButton;

    public ToDoPanel() {
        setLayout(new BorderLayout());

        // Task input and buttons panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        taskInputField = new JTextField(20);
        addButton = new JButton("Add");
        removeButton = new JButton("Remove Selected");

        inputPanel.add(taskInputField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        // Task list model and list
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(taskList);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Add button logic
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String taskText = taskInputField.getText().trim();
                if (!taskText.isEmpty()) {
                    taskListModel.addElement(new Task(taskText));
                    taskInputField.setText("");
                }
            }
        });

        // Remove button logic
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskListModel.remove(selectedIndex);
                }
            }
        });
    }
}
