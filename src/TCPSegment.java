import java.util.ArrayList;
import java.util.List;


public class TCPSegment {
	
	int seq_no;
	int tcp_len;
	
	public TCPSegment(){
		
	}
	
	public TCPSegment(int seq_no, int tcp_len){
		this.seq_no = seq_no;
		this.tcp_len = tcp_len;		
	}

	public int getSeq_no() {
		return seq_no;
	}

	public void setSeq_no(int seq_no) {
		this.seq_no = seq_no;
	}

	public int getTcp_len() {
		return tcp_len;
	}

	public void setTcp_len(int tcp_len) {
		this.tcp_len = tcp_len;
	}
	
	public ArrayList<TCPSegment> find_oos(List<TCPSegment> TCPlist){
		ArrayList<TCPSegment> templist = new ArrayList<TCPSegment>();
		for(int i=0;i<TCPlist.size();i++){
			TCPSegment tcps1 = (TCPSegment) TCPlist.get(i);
			TCPSegment tcps2 = (TCPSegment) TCPlist.get(i+1);
			if(!(tcps1.getSeq_no() < tcps2.getSeq_no())){
			templist.add(tcps2);
			break;			
			}
			}		
		return templist;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
