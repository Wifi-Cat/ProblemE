
public class Rect {

static int x0,y0,x1,y1;
int area;
public Rect(int x0,int y0, int x1, int y1){
	this.x0=x0;
	this.y0=y0;
	this.x1=x1;
	this.y1=y1;
	normalize_pts();
	this.area=computeArea();
}
public static void normalize_pts(){
	int dx=x1-x0;
	int dy=y1-y0;
	if(dx<0){
		int temp=x0;
		x0=x1;
		x1=temp;
	}
	if(dy<0){
		int temp=y0;
		y0=y1;
		y1=temp;
	}
}
public static int computeArea(){
	int dx=x1-x0;
	int dy=y1-y0;
	return dx*dy;
}
}
