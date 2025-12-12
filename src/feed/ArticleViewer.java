package feed;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ArticleViewer {

	public static void showArticles(List<Article> articles) {
		JFrame frame = new JFrame("📰 Articles");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);

		JTextPane textPane = new JTextPane();
		textPane.setContentType("text/html"); // Permite HTML
		textPane.setEditable(false);

		StringBuilder html = new StringBuilder("<html><body style='font-family:sans-serif;'>");

		for (Article article : articles) {
			html.append("<h2>").append(article.getTitle()).append("</h2>");
			html.append("<p><strong>📅 Date:</strong> ").append(article.getPublicationDate()).append("</p>");
			html.append("<p><strong>🔗 Link:</strong> <a href='").append(article.getLink()).append("'>")
			    .append(article.getLink()).append("</a></p>");
			html.append("<p><strong>📝 Text:</strong><br>").append(article.getText().replaceAll("\n", "<br>"))
			    .append("</p>");
			html.append("<hr>");
		}

		html.append("</body></html>");
		textPane.setText(html.toString());

		JScrollPane scrollPane = new JScrollPane(textPane);
		frame.getContentPane().add(scrollPane);

		frame.setVisible(true);
	}
}
