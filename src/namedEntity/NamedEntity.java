package namedEntity;

import namedEntity.temas.*;
import java.awt.Insets;
import javax.swing.JOptionPane;

/*Esta clase modela la nocion de entidad nombrada*/

public class NamedEntity {
	String name;
	String category;
	int frequency;
	Tema topic;

	public NamedEntity(String name, String category, int frequency) {
		super();
		this.name = name;
		this.category = category;
		this.frequency = frequency;
		this.topic = new Otros();
	}

	public Tema getTopic() {
		return topic;
	}

	public void setTopic(Tema topic) {
		this.topic = topic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getFrequency() {
		return this.frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public void incFrequency() {
		this.frequency++;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("==== Named Entity ====\n");
		sb.append("Name     : ").append(name).append("\n");
		sb.append("Frequency: ").append(frequency).append("\n");
		sb.append("Category : ").append(category).append("\n");
		if (topic != null) {
			sb.append("Topic    : ").append(topic.getTopicString()).append("\n");
		}
		return sb.toString();
	}

	public static void showEntitiesInJFrame(java.util.List<NamedEntity> entities, String group) {
		// Collect unique categories
		java.util.Set<String> categories = new java.util.HashSet<>();
		java.util.Set<String> temas = new java.util.HashSet<>();
		for (NamedEntity entity : entities) {
			categories.add(entity.getCategory());
			temas.add(entity.getTopic().getTopicString());
		}
		// Convert to array for JOptionPane
		String[] categoryArray = categories.toArray(new String[0]);
		if (categoryArray.length == 0) {
			JOptionPane.showMessageDialog(null, "No " + group + " available.", "Info", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		// Do the same for the topics
		String[] topicsArray = temas.toArray(new String[0]);
		if (topicsArray.length == 0) {
			JOptionPane.showMessageDialog(null, "No topics available.", "Info", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		while (true) {
            String[] optionsArray = {"CATEGORÍAS", "TEMAS"};
			String selectedOption = (String) JOptionPane.showInputDialog(
					null,
					"Select what kind of content separation you want (Cancel to exit):",
					"Selection",
					JOptionPane.QUESTION_MESSAGE,
					null,
					optionsArray,
					optionsArray[0]);

			if (selectedOption == null) {
				break; // User cancelled
			} else if (selectedOption.equals("CATEGORÍAS")) {
				String selectedCategory = (String) JOptionPane.showInputDialog(
						null,
						"Select a " + group + " to view:",
						"" + group + " Selection",
						JOptionPane.QUESTION_MESSAGE,
						null,
						categoryArray,
						categoryArray[0]);

				if (selectedCategory == null) {
					; // User cancelled
				} else {
					StringBuilder sb = new StringBuilder();
					for (NamedEntity entity : entities) {
						if (selectedCategory.equals(entity.getCategory())) {
							sb.append(entity.toString()).append("\n\n");
						}
					}
					if (sb.length() == 0) {
						sb.append("No entities found for category: ").append(selectedCategory);
					}
					javax.swing.JTextArea textArea = new javax.swing.JTextArea(sb.toString());
					textArea.setEditable(false);
					textArea.setLineWrap(true);
					textArea.setWrapStyleWord(true);
					textArea.setMargin(new Insets(10, 10, 10, 10));
					javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(textArea);
					scrollPane.setPreferredSize(new java.awt.Dimension(500, 400));
					JOptionPane.showMessageDialog(null, scrollPane, "Named Entities - " + selectedCategory,
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				String selectedTopic = (String) JOptionPane.showInputDialog(
						null,
						"Select a topic to view:",
						"Topic Selection",
						JOptionPane.QUESTION_MESSAGE,
						null,
						topicsArray,
						topicsArray[0]);

				if (selectedTopic == null) {
					; // user cancelled
				} else {
					StringBuilder sb = new StringBuilder();
					for (NamedEntity entity : entities) {
						if (selectedTopic.equals(entity.getTopic().getTopicString())) {
							sb.append(entity.toString()).append("\n\n");
						}
					}
					if (sb.length() == 0) {
						sb.append("No entities found for topic: ").append(selectedTopic);
					}
					javax.swing.JTextArea textArea = new javax.swing.JTextArea(sb.toString());
					textArea.setEditable(false);
					textArea.setLineWrap(true);
					textArea.setWrapStyleWord(true);
					textArea.setMargin(new Insets(10, 10, 10, 10));
					javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(textArea);
					scrollPane.setPreferredSize(new java.awt.Dimension(500, 400));
					JOptionPane.showMessageDialog(null, scrollPane, "Named Entities - " + selectedTopic,
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	public void prettyPrint() {
		System.out.println(this.getName() + " " + this.getFrequency());
	}

}
