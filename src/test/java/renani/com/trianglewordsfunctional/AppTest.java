package renani.com.trianglewordsfunctional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    public void testSearchAndGroupTriangleWords(){
        String tmp = "words.txt";
        String s = App.searchAndGroupTriangleWords(tmp);
        String expected="{\"1\":\"a\",\"4\":\"bag\",\"5\":\"if,face,an\",\"6\":\"of,edge,bar,band,at\",\"7\":\"we,read,need,man,is,feel,fail,case,call,beat,bank,air\",\"8\":\"wage,ride,real,oil,law,his,here,have,hair,field,come,child,bone,agree\",\"9\":\"use,tax,tall,seat,say,range,path,much,milk,match,leave,leader,fund,effect,east,bridge,both,above\",\"10\":\"watch,warm,video,unable,song,soil,sky,relief,pass,part,object,move,less,grey,could,civil,burn,beneath,belong,agency\",\"11\":\"woman,vary,upon,type,title,single,sample,other,only,notice,length,intend,happy,freedom,floor,figure,family,event,careful,ancient,already\",\"12\":\"widely,travel,tooth,start,remove,mistake,merely,little,increased,incident,despite,decision,confirm,confidence,capacity,building,assume,approach,ability\",\"13\":\"whilst,threaten,theory,spirit,respond,probably,private,prison,perform,objective,lovely,growth,gentleman,future,deputy,democratic,content,closely,appoint,apparent,accompany\",\"14\":\"various,totally,request,quality,procedure,individual,educational,definition,achievement\",\"15\":\"understand,southern,solicitor,security,represent,question,intention,equipment,atmosphere\",\"16\":\"suggestion,ourselves,increasingly,distinction,currently\",\"17\":\"throughout,instrument,conservative\",\"18\":\"construction\"}";
        assertEquals(expected,s);
    }
}