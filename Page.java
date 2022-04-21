import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Page extends Applet implements ActionListener, ItemListener,TextListener{
 
  TextField txt;
  List lst;
  Button add,remove,moveup,movedown;
 
  public void init(){
   
   add(new Label("Enter/Remove Network name"));
   
   add(txt=new TextField(20));
   
   add(lst=new List());
   
   lst.add("LAN");
   lst.add("MAN");
   lst.add("WAN");
   lst.add("Personal area N/w");
   
   add(add=new Button("Add"));
   add(remove=new Button("Remove"));
   add(moveup=new Button("Move Up"));
   add(movedown=new Button("Move Down"));
   
   
   
     lst.addItemListener(this);
     txt.addTextListener(this);
     
     add.addActionListener(this);
     remove.addActionListener(this);
     moveup.addActionListener(this);
     movedown.addActionListener(this);
   
   
  
   
  }

  @Override
  public void actionPerformed(ActionEvent e) {
  
   
   
    if(( e.getSource()==add)&& (!(txt.getText().equals("")))){
    
        boolean b=true;
         
        for(int i=0;i<lst.getItemCount();i++){
         
            
           if((txt.getText()).equalsIgnoreCase(lst.getItem(i))){
          
            showStatus("The name already exists");
            b=false;
            break;
           } 
           
          }
        
         if(b){
          
          lst.add(txt.getText());
          showStatus("");
          showStatus(txt.getText()+" "+"has been added");
         }
        
    }
   
    if(e.getSource()==remove){
     
        if(lst.getSelectedIndex()!=(-1))
          {
            
            showStatus(lst.getSelectedItem()+" "+"name Removed");
            lst.remove(lst.getSelectedIndex());
            
          }
         else
          {
         
            showStatus("No such name Found");
          }
    }
   
   if(e.getSource()==moveup){
    
       String str[]=new String[lst.getItemCount()];
       String temp;
      
         str=lst.getItems();
            
          temp=lst.getItem(lst.getSelectedIndex()-1);
          str[lst.getSelectedIndex()-1]=str[lst.getSelectedIndex()];
          str[lst.getSelectedIndex()]=temp;
              
            lst.removeAll();
          
            for(int i=0;i<str.length;i++)
              {
               lst.add(str[i]);
              }
         
        
        
     
   }
   
   if(e.getSource()==movedown){
    
       String str[]=new String[lst.getItemCount()];
       String temp;
       
        str=lst.getItems();
            
         temp=lst.getItem(lst.getSelectedIndex()+1);
         str[lst.getSelectedIndex()+1]=str[lst.getSelectedIndex()];
         str[lst.getSelectedIndex()]=temp;
            
           lst.removeAll();
          
            for(int i=0;i<str.length;i++)
              {
               lst.add(str[i]);
              }
         
   }
   
   
    }
   
   
  

  @Override
  public void itemStateChanged(ItemEvent e) {
   
   
     if(lst.getSelectedIndex()==0){
      
        moveup.setEnabled(false);
        
     }else{ 
      
        moveup.setEnabled(true);
        
     }
   
     if(lst.getSelectedIndex()==(lst.getItemCount()-1) )
      {
      
        movedown.setEnabled(false);
      }else
     {
        movedown.setEnabled(true);
     }

   
  }

  @Override
  public void textValueChanged(TextEvent arg0) {
  
   showStatus(txt.getText());
  }

}
