package com.neogul.ui.view.reclist;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.neogul.data.dao.Reclist_Dao;
import com.neogul.data.dao.Saleslist_Dao;
import com.neogul.data.dao.Wishlist_Dao;
import com.neogul.data.dto.TB_Reclist;
import com.neogul.data.dto.TB_Saleslist;
import com.neogul.data.dto.TB_Wishlist;
import com.neogul.ui.view.reclist.ReclistForm.ReclistFormFactory;
import com.neogul.ui.view.reclist.ReclistLogic.ReclistLogicFactory;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.Or;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringView(name = ReclistView.VIEW_NAME)
public class ReclistView extends CssLayout implements View {

	public static final String VIEW_NAME = "상품 추천";
	private ReclistGrid grid;

	@Autowired
	private ReclistFormFactory formFactory;

	/*
	 * @Autowired private pDao pDao;
	 */
	//@Autowired
	//private reclistRepository pDao;

	@Autowired
	private Reclist_Dao pDao;
	@Autowired
	private Wishlist_Dao wDao;
	@Autowired
	private Saleslist_Dao sDao;
	
//	@Autowired
//	private reclistContainer reclistContainer;

	private ReclistForm form;

	private ReclistLogic viewLogic;
	private ComboBox Typecombo;
	private Button searchreclist;
	private Button newreclist;
	private BeanItemContainer<TB_Reclist> gridcontainer;
	private BeanItemContainer<TB_Wishlist> gridcontainer2;
	private BeanItemContainer<TB_Saleslist> gridcontainer3;
	@Autowired
	private ReclistLogicFactory logicFactory;

	public HorizontalLayout createTopBar() {
		Typecombo = new ComboBox();
		searchreclist = new Button(FontAwesome.TIMES);
		
		Typecombo.addItems("전체","접속중","정상","차단","반출중");
		
		Typecombo.select("전체");
		Typecombo.setCaption("상태");
		Typecombo.setNullSelectionAllowed(false);
		Typecombo.setTextInputAllowed(false);
		TextField filter = new TextField();
		filter.setStyleName("filter-textfield");
		filter.setInputPrompt("USER ID");
		filter.setImmediate(true);
		TB_Reclist di =new TB_Reclist();
		
		try {
			gridcontainer = new BeanItemContainer<>(TB_Reclist.class, pDao.fnList(di));
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			Typecombo.addValueChangeListener(e->{
				updateproduct();
				String filtercombo = (String) Typecombo.getValue();
				if (filtercombo == null || "".equals(filtercombo)||filtercombo.equals("전체")) {
					gridcontainer.removeAllContainerFilters();
				} else {
					gridcontainer
							.addContainerFilter(new Or(
									new SimpleStringFilter("Type", filtercombo, true, false)));
				}
				grid.setContainerDataSource(gridcontainer);
			});
			
			//searchreclist.addClickListener(event -> {
			filter.addTextChangeListener(event -> {
			String filterText = (String) event.getText();
			//String filterText = filter.getValue();
			if (filterText == null || "".equals(filterText)) {
				gridcontainer.removeAllContainerFilters();
				if(!Typecombo.getValue().equals("전체"))
					gridcontainer.addContainerFilter(
						new SimpleStringFilter("Type", (String) Typecombo.getValue(), true, false));
	
			} else {
					gridcontainer
							.addContainerFilter(new SimpleStringFilter("user_id", filterText, true, false));
				}
				grid.setContainerDataSource(gridcontainer);
			}

			);
			
			
			
			searchreclist.addClickListener(event ->{
				filter.clear();
				Typecombo.select("전체");
				updateproduct();
			});
		
		
		FormLayout Typeform = new FormLayout();
		FormLayout searchform = new FormLayout();
		Typecombo.setSizeUndefined();
		Typeform.addComponent(Typecombo);
		//Typeform.setWidth(50,UNITS_PIXELS);
		
		newreclist = new Button("New Product");
		newreclist.addStyleName(ValoTheme.BUTTON_PRIMARY);
		newreclist.setIcon(FontAwesome.PLUS_CIRCLE);
		newreclist.addClickListener(event -> viewLogic.newproduct());
		
		//newreclist.setVisible(false);
		
		HorizontalLayout topLayout = new HorizontalLayout();
		CssLayout searchlayout = new CssLayout();
		topLayout.setSpacing(true);
		searchlayout.addComponents(filter,searchreclist);
		topLayout.setWidth("100%");
		searchlayout.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		topLayout.addComponent(Typeform);
		
		searchlayout.setCaption("USER ID :");
		searchlayout.setSizeUndefined();
		searchform.setSizeUndefined();
		searchform.addComponent(searchlayout);
		searchform.setComponentAlignment(searchlayout, Alignment.MIDDLE_LEFT);
		
		topLayout.setSpacing(true);
		topLayout.addComponent(searchform);
		//topLayout.addComponent(searchreclist);
		topLayout.setSizeUndefined();
		topLayout.addComponent(newreclist);
		topLayout.setComponentAlignment(Typeform, Alignment.MIDDLE_LEFT);
		topLayout.setComponentAlignment(searchform, Alignment.MIDDLE_LEFT);
		topLayout.setComponentAlignment(newreclist, Alignment.MIDDLE_RIGHT);
		topLayout.setStyleName("top-bar");
		return topLayout;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		viewLogic.enter(event.getParameters());
	}

	public void showError(String msg) {
		Notification.show(msg, Type.ERROR_MESSAGE);
	}

	public void showSaveNotification(String msg) {
		Notification.show(msg, Type.TRAY_NOTIFICATION);
	}

	public void setNewreclistEnabled(boolean enabled) {
		newreclist.setEnabled(enabled);
	}

	public void clearSelection() {
		grid.getSelectionModel().reset();
	}

	public void selectRow(TB_Reclist row) {
		((Grid.SelectionModel.Single) grid.getSelectionModel()).select(row.getName());
	}

	public TB_Reclist getSelectedRow() {
		return grid.getSelectedRow();
	}

	public void editproduct(TB_Reclist reclist) {
		if (reclist != null) {
			form.addStyleName("visible");
			form.setEnabled(true);
		} else {
			form.removeStyleName("visible");
			// Issue #286
			// form.setEnabled(false);
		}
		form.editproduct(reclist);
	}

	public void updateproduct() {
		// We do not save anything to the backend in this demo
		//reclistContainer.addItem(reclist);
		//reclistContainer.insertItem(reclist);
		TB_Reclist di =new TB_Reclist();
		TB_Wishlist wi =new TB_Wishlist();
		TB_Saleslist si =new TB_Saleslist();
		try {
			pDao.fnDeleteAll(di);
			gridcontainer2 = new BeanItemContainer<>(TB_Wishlist.class, wDao.fnList(wi));
			gridcontainer3 = new BeanItemContainer<>(TB_Saleslist.class, sDao.fnList(si));
			
			 int i,j,k,n=0;
	            double a1=0,a2=0,a3=0,res=0;
	            int[][] ps=new int[10][100];   
	            int[] wish=new int[10];
	            double[] rec=new double[10];
	            for(i=0;i<10;i++){
	               wish[i]=0;
	               rec[i]=0;
	            }
	            for(i=0;i<gridcontainer2.size();i++){
	               if(gridcontainer2.getIdByIndex(i).getName().equals("banana"))
	                  wish[0]+=1;
	               else if(gridcontainer2.getIdByIndex(i).getName().equals("apple"))
	                  wish[1]+=1;
	               else if(gridcontainer2.getIdByIndex(i).getName().equals("pencil"))
	                  wish[2]+=1;
	               else if(gridcontainer2.getIdByIndex(i).getName().equals("eraser"))
	                  wish[3]+=1;
	               else if(gridcontainer2.getIdByIndex(i).getName().equals("coke"))
	                  wish[4]+=1;
	               else if(gridcontainer2.getIdByIndex(i).getName().equals("cider"))
	                  wish[5]+=1;
	               else if(gridcontainer2.getIdByIndex(i).getName().equals("wallet"))
	                  wish[6]+=1;
	               else if(gridcontainer2.getIdByIndex(i).getName().equals("highhill"))
	                  wish[7]+=1;
	               else if(gridcontainer2.getIdByIndex(i).getName().equals("arduino"))
	                  wish[8]+=1;
	               else if(gridcontainer2.getIdByIndex(i).getName().equals("mouse"))
	                  wish[9]+=1;
	            }
	            for(i=0;i<10;i++)
	            	System.out.println(wish[i]);
	            
	            for(i=0;i<gridcontainer3.size();i++){
	               ps[0][i]=gridcontainer3.getIdByIndex(i).getBanana();
	               ps[1][i]=gridcontainer3.getIdByIndex(i).getApple();
	               ps[2][i]=gridcontainer3.getIdByIndex(i).getPencil();
	               ps[3][i]=gridcontainer3.getIdByIndex(i).getEraser();
	               ps[4][i]=gridcontainer3.getIdByIndex(i).getCoke();
	               ps[5][i]=gridcontainer3.getIdByIndex(i).getCider();
	               ps[6][i]=gridcontainer3.getIdByIndex(i).getWallet();
	               ps[7][i]=gridcontainer3.getIdByIndex(i).getHighhill();
	               ps[8][i]=gridcontainer3.getIdByIndex(i).getArduino();
	               ps[9][i]=gridcontainer3.getIdByIndex(i).getMouse();
	            }
	            
	            for(i=0;i<10;i++)
	            	System.out.println(ps[i][0]);
	            
	            for(j=0;j<10;j++){
	               res=0;
	               if(wish[j]==0){
	                  for(i=0;i<10;i++){
	                     if(i==j)
	                        continue;
	                     if(wish[i]==0)
	                        continue;
	                     
	                     for(k=0;k<gridcontainer.size();k++){
	                        a1=a1+ps[j][k]*ps[i][k];
	                        a2=a2+ps[j][k]*ps[j][k];
	                        a3=a3+ps[i][k]*ps[i][k];
	                     }
	                     if(res<a1/(Math.sqrt(a2)*Math.sqrt(a3))){
	                        res=a1/(Math.sqrt(a2)*Math.sqrt(a3));
	                        n=i;
	                     }
	                  }
	                  rec[j]= wish[n]*res;
	               }
	            }
	            for(i=0;i<10;i++)
	            	System.out.println(rec[i]);
	            
	            double t1=0;
	            int t2=0;
	            TB_Reclist vo=new TB_Reclist();
	            for(i=0;i<10;i++){
	               if(t1<rec[i]){
	                  t1=rec[i];
	                  t2=i;
	               }
	            }
	            if(t2==0){
	            	vo.setName("banana");
	            	vo.setPrice(1000);
	            }
	            else if(t2==1){
	            	vo.setName("apple");
	            	vo.setPrice(1000);
	            }
	            else if(t2==2){
	            	vo.setName("pencil");
	            	vo.setPrice(1000);
	            }
	            else if(t2==3){
	            	vo.setName("eraser");
	            	vo.setPrice(1000);
	            }
	            else if(t2==4){
	            	vo.setName("coke");
	            	vo.setPrice(1000);
	            }
	            else if(t2==5){
	            	vo.setName("cider");
	            	vo.setPrice(1000);
	            }
	            else if(t2==6){
	            	vo.setName("wallet");
	            	vo.setPrice(1000);
	            }
	            else if(t2==7){
	            	vo.setName("highhill");
	            	vo.setPrice(1000);
	            }
	            else if(t2==8){
	            	vo.setName("arduino");
	            	vo.setPrice(1000);
	            }
	            else if(t2==9){
	            	vo.setName("mouse");
	            	vo.setPrice(1000);
	            }
	            System.out.println(vo.getName());
	            pDao.fnInsert(vo);
	            //t2번째 상품 추천, 추천목록테이블에 추가
	            rec[t2]=0;
	            t1=0;
	            for(i=0;i<10;i++){
	               if(t1<rec[i]){
	                  t1=rec[i];
	                  t2=i;
	               }
	            }
	            if(t2==0){
	            	vo.setName("banana");
	            	vo.setPrice(1000);
	            }
	            else if(t2==1){
	            	vo.setName("apple");
	            	vo.setPrice(1000);
	            }
	            else if(t2==2){
	            	vo.setName("pencil");
	            	vo.setPrice(1000);
	            }
	            else if(t2==3){
	            	vo.setName("eraser");
	            	vo.setPrice(1000);
	            }
	            else if(t2==4){
	            	vo.setName("coke");
	            	vo.setPrice(1000);
	            }
	            else if(t2==5){
	            	vo.setName("cider");
	            	vo.setPrice(1000);
	            }
	            else if(t2==6){
	            	vo.setName("wallet");
	            	vo.setPrice(1000);
	            }
	            else if(t2==7){
	            	vo.setName("highhill");
	            	vo.setPrice(1000);
	            }
	            else if(t2==8){
	            	vo.setName("arduino");
	            	vo.setPrice(1000);
	            }
	            else if(t2==9){
	            	vo.setName("mouse");
	            	vo.setPrice(1000);
	            }
	            
	            pDao.fnInsert(vo);
	            //t2번째 상품 추천, 추천목록테이블에 추가
	            rec[t2]=0;
	            t1=0;
	            for(i=0;i<10;i++){
	               if(t1<rec[i]){
	                  t1=rec[i];
	                  t2=i;
	               }
	            }
	            if(t2==0){
	            	vo.setName("banana");
	            	vo.setPrice(1000);
	            }
	            else if(t2==1){
	            	vo.setName("apple");
	            	vo.setPrice(1000);
	            }
	            else if(t2==2){
	            	vo.setName("pencil");
	            	vo.setPrice(1000);
	            }
	            else if(t2==3){
	            	vo.setName("eraser");
	            	vo.setPrice(1000);
	            }
	            else if(t2==4){
	            	vo.setName("coke");
	            	vo.setPrice(1000);
	            }
	            else if(t2==5){
	            	vo.setName("cider");
	            	vo.setPrice(1000);
	            }
	            else if(t2==6){
	            	vo.setName("wallet");
	            	vo.setPrice(1000);
	            }
	            else if(t2==7){
	            	vo.setName("highhill");
	            	vo.setPrice(1000);
	            }
	            else if(t2==8){
	            	vo.setName("arduino");
	            	vo.setPrice(1000);
	            }
	            else if(t2==9){
	            	vo.setName("mouse");
	            	vo.setPrice(1000);
	            }
	            
	            pDao.fnInsert(vo);
	            //t2번째 상품 추천, 추천목록테이블에 추가
	         
	            gridcontainer = new BeanItemContainer<>(TB_Reclist.class, pDao.fnList(di));
	            grid.setContainerDataSource(gridcontainer);
			
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	public void removereclist(TB_reclist reclist) {
//		reclistContainer.removeItem(reclist);
//	}

	@PostConstruct
	private void init() {
		viewLogic = logicFactory.createLogic(this);

		setSizeFull();
		addStyleName("crud-view");
		HorizontalLayout topLayout = createTopBar();
		VerticalLayout toplabel = new VerticalLayout();
		Label label =new Label("reclist State");
		Label label2 =new Label("Process Management / Current State");
		label.setStyleName(ValoTheme.LABEL_H1);
		label2.setStyleName(ValoTheme.LABEL_H3);
		toplabel.addComponents(label,label2);
		toplabel.setSizeUndefined();
		label.setSizeUndefined();
		label2.setSizeUndefined();
		label.setStyleName(ValoTheme.LABEL_NO_MARGIN,true);
		label.setStyleName(ValoTheme.LABEL_COLORED,true);
		label2.setStyleName(ValoTheme.LABEL_BOLD,true);
		
		try {
			grid = new ReclistGrid();
			grid.addSelectionListener(event -> viewLogic.rowSelected(grid.getSelectedRow()));
			//grid.setContainerDataSource(reclistContainer);
			
			/*List<TB_reclist> data = pDao.fnList(new TB_reclist());
	        grid.setContainerDataSource(new BeanItemContainer<>(TB_reclist.class, data));
			*/
	        //System.out.println(data.get(0).getreclist_id());
	        
			TB_Reclist di = new TB_Reclist();
			updateproduct();
			
			
	        VerticalLayout barAndGridLayout = new VerticalLayout();
			//barAndGridLayout.addComponent(toplabel);
			barAndGridLayout.addComponent(topLayout);
			barAndGridLayout.addComponent(grid);
			barAndGridLayout.setMargin(true);
			barAndGridLayout.setSpacing(true);
			barAndGridLayout.setSizeFull();
			barAndGridLayout.setExpandRatio(grid, 1);
			barAndGridLayout.setStyleName("crud-main-layout");

			addComponent(barAndGridLayout);

			form = formFactory.createForm(viewLogic);
			//form.setCategories(pDao.fnList(new TB_reclist()).subList(0,3));
			addComponent(form);

			viewLogic.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

