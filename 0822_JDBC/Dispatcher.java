import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Dispatcher {

	public Dispatcher() {
		createGUI();
		setEvent();
	}
	
	private void setListData() {
		ArrayList<Book> data = man.listBooks();
		DefaultListModel<Book> model = new DefaultListModel<>();
		for(int i = 0 ; i < data.size(); i++) {
			model.add(i, data.get(i));
		}
		list.setModel(model);
	}
	
	private void setEvent() {
		// TODO Auto-generated method stub
		f.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosed(e);
				System.exit(0);
			}	
			
		});
		
		bInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				man.insertBook(new Book(tfIsbn.getText(), tfTitle.getText(), tfPublisher.getText(), Integer.parseInt(tfPrice.getText()),tfDescription.getText(),Integer.parseInt(tfAuthorno.getText())));;
				setListData();
			}
		});
		
		bUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				man.updateBook(new Book(tfIsbn.getText(), tfTitle.getText(), tfPublisher.getText(), Integer.parseInt(tfPrice.getText()),tfDescription.getText(),Integer.parseInt(tfAuthorno.getText())));;
				setListData();
			}
		});
		
		bDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				man.deleteBook((tfIsbn.getText()));
				setListData();
			}
		});
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getFirstIndex());
				System.out.println(e.getLastIndex());
				System.out.println(e.getSource());
				System.out.println(e.getValueIsAdjusting());
			
				if(!e.getValueIsAdjusting())
				{
					JList list = (JList)e.getSource();
					Book b = (Book)list.getSelectedValue();
					if(b!=null) {
						tfIsbn.setText(b.getIsbn());
						tfTitle.setText(b.getTitle());
						tfPublisher.setText(b.getPublisher());
						tfPrice.setText(b.getPrice()+"");
						tfDescription.setText(b.getDescription());
						tfAuthorno.setText(b.getAuthorno()+"");						
					}					
				}
			}
		});
	}

	JFrame f;
	JPanel pUp;
	JPanel pDown;
	JTextField tfIsbn;
	JTextField tfTitle;	
	JTextField tfPublisher;
	JTextField tfPrice;
	JTextField tfDescription;
	JTextField tfAuthorno;
	JButton bInsert;
	JButton bUpdate;
	JButton bDelete;
	JList list;
	
	
	
	//학번 이름 성별 생일
	//	  리스트
	// 삽입 업데이트 삭제	
	private void createGUI() {
		// TODO Auto-generated method stub
		f = new JFrame("도서관리");
		pUp = new JPanel();
		pDown = new JPanel();
		tfIsbn = new JTextField();
		tfTitle = new JTextField();		
		tfPublisher = new JTextField();
		tfPrice = new JTextField();
		tfDescription = new JTextField();
		tfAuthorno = new JTextField();
		bInsert = new JButton();
		bUpdate = new JButton();
		bDelete = new JButton();
		list = new JList<>();
		
		tfIsbn.setColumns(6);
		tfTitle.setColumns(6);		
		tfPublisher.setColumns(6);
		tfPrice.setColumns(6);
		tfDescription.setColumns(6);
		tfAuthorno.setColumns(6);
		
		
		//위쪽 판낼
		pUp.add(tfIsbn);
		pUp.add(tfTitle);
		pUp.add(tfPublisher);		
		pUp.add(tfPrice);
		pUp.add(tfDescription);
		pUp.add(tfAuthorno);
		//판낼 프레임에 삽입
		f.add(pUp,BorderLayout.NORTH);
		
		
		bInsert.setText("Insert");
		bUpdate.setText("Update");
		bDelete.setText("Delete");		
		pDown.add(bInsert);
		pDown.add(bUpdate);
		pDown.add(bDelete);
		f.add(pDown,BorderLayout.SOUTH);
		
		f.add(new JScrollPane(list) ,BorderLayout.CENTER);
		
		f.setSize(500,500);
		f.setLocation(700,300);
		f.setVisible(true);
		
	}
	BookDAO man;
	private void go() {
		man = new BookDAO();
		setListData();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Dispatcher().go();
	}

}
