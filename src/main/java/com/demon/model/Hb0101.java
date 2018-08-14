package com.demon.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bootplus.Util.DateUtil;
import com.bootplus.core.base.BaseModel;

/**
 * @Table(name = "琛ㄥ悕", catalog = "鏁版嵁搴撳悕")
 * @author liulu
 *
 */
@Entity
@Table(name = "hb0101", catalog = "springboot")
public class Hb0101 extends BaseModel implements java.io.Serializable{
	
	private static final long serialVersionUID = -3265156817321658L;
	
	
	//Fields
	private Integer id;
		
	/* 閻у妾伴崥锟� */
	private  String hb0101001;
	
	/* 婵挸鎮� */
	private  String hb0101002;
	
	/* 閹靛婧� */
	private  String hb0101003;
	
	/* 闁喚顔� */
	private  String hb0101004;
	
	/* 閹存劕濮涢惂濠氭濞嗏剝鏆� */
	private  Integer hb0101005;
	
	/* 娑撳﹥顐奸幋鎰閻у妾伴弮鍫曟？ */
	private  Date hb0101006;
	
	/* 閻у妾伴崷鎵仯 */
	private  String hb0101007;
	
	/* 閸戦缚闊╅弮銉︽埂 */
	private  Date hb0101008;
	
	/* 閹冨焼 */
	private  String hb0101009;
	
	/* 闊偂鍞ょ拠浣稿娇閻拷 */
	private  String hb0101010;
	
	/* 鐎靛棛鐖� */
	private  String hb0101011;
	
	/* 閺勭數袨 */
	private  String hb0101012;
	
	/* QQ閸欓鐖� */
	private  String hb0101013;
	
	/* 瀵邦喕淇婇崣锟� */
	private  String hb0101014;
	
	/* 娴溿倖妲楃�靛棛鐖� */
	private  String hb0101015;
	
	/* 鐎瑰鍙� */
	private  String hb0101016;
	
	/* 鐏炵偞锟斤拷 */
	private  String hb0101017;
	
	/* 閸ョ偓鐖ｇ紓鏍у娇 */
	private  String hb0101018;
	
	/* 鏉╁洦婀￠弮鍫曟？ */
	private  Date hb0101019;
	
	/* 閹崵娈戦惂濠氭濞嗏剝鏆� */
	private  Integer hb0101020;
	
	/* 閺堬拷閺傛壆娅ラ梽鍡樻闂傦拷 */
	private  Date hb0101021;
	
	/* 閻у妾伴柨娆掝嚖濞嗏剝鏆� */
	private  Integer hb0101022;
	
	/* 閸欘垯浜掗惂濠氭閺冨爼妫� */
	private  Date hb0101023;
	
	/* REV_ */
	private  Integer hb9999997;
	
	/* 娑撴彃褰� */
	private  String hb9999998;
	
	/* 閻樿埖锟斤拷 */
	private  String hb9999999;
	
	/* 鐞涘瞼绱崣锟� */
	private  String rowid_;
	
		
//	//Get Methods
//	@Id
//	@GeneratedValue(strategy = IDENTITY)
//	@Column(name = "ID_", unique = true, nullable = false)
//	public Integer getId() {
//		return this.id;
//	}
//	
	@Column(name = "Hb0101001", length =64)
	public String getHb0101001() {
		return this.hb0101001;
	}


	@Column(name = "Hb0101002", length =64)
	public String getHb0101002() {
		return this.hb0101002;
	}


	@Column(name = "Hb0101003", length =16)
	public String getHb0101003() {
		return this.hb0101003;
	}


	@Column(name = "Hb0101004", length =64)
	public String getHb0101004() {
		return this.hb0101004;
	}


	@Column(name = "Hb0101005")
	public Integer getHb0101005() {
		return this.hb0101005;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Hb0101006", length = 19)
	public Date getHb0101006() {
		return this.hb0101006;
	}


	@Column(name = "Hb0101007", length =128)
	public String getHb0101007() {
		return this.hb0101007;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Hb0101008", length = 19)
	public Date getHb0101008() {
		return this.hb0101008;
	}


	@Column(name = "Hb0101009", length =2)
	public String getHb0101009() {
		return this.hb0101009;
	}


	@Column(name = "Hb0101010", length =32)
	public String getHb0101010() {
		return this.hb0101010;
	}


	@Column(name = "Hb0101011", length =128)
	public String getHb0101011() {
		return this.hb0101011;
	}


	@Column(name = "Hb0101012", length =16)
	public String getHb0101012() {
		return this.hb0101012;
	}


	@Column(name = "Hb0101013", length =16)
	public String getHb0101013() {
		return this.hb0101013;
	}


	@Column(name = "Hb0101014", length =64)
	public String getHb0101014() {
		return this.hb0101014;
	}


	@Column(name = "Hb0101015", length =128)
	public String getHb0101015() {
		return this.hb0101015;
	}


	@Column(name = "Hb0101016")
	public String getHb0101016() {
		return this.hb0101016;
	}


	@Column(name = "Hb0101017")
	public String getHb0101017() {
		return this.hb0101017;
	}


	@Column(name = "Hb0101018", length =16)
	public String getHb0101018() {
		return this.hb0101018;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Hb0101019", length = 19)
	public Date getHb0101019() {
		return this.hb0101019;
	}


	@Column(name = "Hb0101020")
	public Integer getHb0101020() {
		return this.hb0101020;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Hb0101021", length = 19)
	public Date getHb0101021() {
		return this.hb0101021;
	}


	@Column(name = "Hb0101022")
	public Integer getHb0101022() {
		return this.hb0101022;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Hb0101023", length = 19)
	public Date getHb0101023() {
		return this.hb0101023;
	}


	@Column(name = "Hb9999997")
	public Integer getHb9999997() {
		return this.hb9999997;
	}


	@Column(name = "Hb9999998", length =64)
	public String getHb9999998() {
		return this.hb9999998;
	}


	@Column(name = "Hb9999999", length =2)
	public String getHb9999999() {
		return this.hb9999999;
	}


	@Column(name = "RowID_", length =64)
	public String getRowID_() {
		return this.rowid_;
	}


	
	//Set Methods
	public void setId(Integer id) {
		this.id = id;
	}
	public void setHb0101001(String hb0101001) {
		this.hb0101001 = hb0101001;
	}

 
	public void setHb0101002(String hb0101002) {
		this.hb0101002 = hb0101002;
	}

 
	public void setHb0101003(String hb0101003) {
		this.hb0101003 = hb0101003;
	}

 
	public void setHb0101004(String hb0101004) {
		this.hb0101004 = hb0101004;
	}

 
	public void setHb0101005(Integer hb0101005) {
		this.hb0101005 = hb0101005;
	}

 
	public void setHb0101006(Date hb0101006) {
		this.hb0101006 = hb0101006;
	}

 
	public void setHb0101007(String hb0101007) {
		this.hb0101007 = hb0101007;
	}

 
	public void setHb0101008(Date hb0101008) {
		this.hb0101008 = hb0101008;
	}

 
	public void setHb0101009(String hb0101009) {
		this.hb0101009 = hb0101009;
	}

 
	public void setHb0101010(String hb0101010) {
		this.hb0101010 = hb0101010;
	}

 
	public void setHb0101011(String hb0101011) {
		this.hb0101011 = hb0101011;
	}

 
	public void setHb0101012(String hb0101012) {
		this.hb0101012 = hb0101012;
	}

 
	public void setHb0101013(String hb0101013) {
		this.hb0101013 = hb0101013;
	}

 
	public void setHb0101014(String hb0101014) {
		this.hb0101014 = hb0101014;
	}

 
	public void setHb0101015(String hb0101015) {
		this.hb0101015 = hb0101015;
	}

 
	public void setHb0101016(String hb0101016) {
		this.hb0101016 = hb0101016;
	}

 
	public void setHb0101017(String hb0101017) {
		this.hb0101017 = hb0101017;
	}

 
	public void setHb0101018(String hb0101018) {
		this.hb0101018 = hb0101018;
	}

 
	public void setHb0101019(Date hb0101019) {
		this.hb0101019 = hb0101019;
	}

 
	public void setHb0101020(Integer hb0101020) {
		this.hb0101020 = hb0101020;
	}

 
	public void setHb0101021(Date hb0101021) {
		this.hb0101021 = hb0101021;
	}

 
	public void setHb0101022(Integer hb0101022) {
		this.hb0101022 = hb0101022;
	}

 
	public void setHb0101023(Date hb0101023) {
		this.hb0101023 = hb0101023;
	}

 
	public void setHb9999997(Integer hb9999997) {
		this.hb9999997 = hb9999997;
	}

 
	public void setHb9999998(String hb9999998) {
		this.hb9999998 = hb9999998;
	}

 
	public void setHb9999999(String hb9999999) {
		this.hb9999999 = hb9999999;
	}

 
	public void setRowID_(String rowid_) {
		this.rowid_ = rowid_;
	}

 
	
	//Constructors
	public Hb0101() {}
	
	public Hb0101(String hb0101001,String hb0101002,String hb0101003,String hb0101004,Integer hb0101005,
		Date hb0101006,String hb0101007,Date hb0101008,String hb0101009,String hb0101010,
		String hb0101011,String hb0101012,String hb0101013,String hb0101014,String hb0101015,
		String hb0101016,String hb0101017,String hb0101018,Date hb0101019,Integer hb0101020,
		Date hb0101021,Integer hb0101022,Date hb0101023,Integer hb9999997,String hb9999998,
		String hb9999999,String rowid_){    
		setHb0101001(hb0101001);
		setHb0101002(hb0101002);
		setHb0101003(hb0101003);
		setHb0101004(hb0101004);
		setHb0101005(hb0101005);
		setHb0101006(hb0101006);
		setHb0101007(hb0101007);
		setHb0101008(hb0101008);
		setHb0101009(hb0101009);
		setHb0101010(hb0101010);
		setHb0101011(hb0101011);
		setHb0101012(hb0101012);
		setHb0101013(hb0101013);
		setHb0101014(hb0101014);
		setHb0101015(hb0101015);
		setHb0101016(hb0101016);
		setHb0101017(hb0101017);
		setHb0101018(hb0101018);
		setHb0101019(hb0101019);
		setHb0101020(hb0101020);
		setHb0101021(hb0101021);
		setHb0101022(hb0101022);
		setHb0101023(hb0101023);
		setHb9999997(hb9999997);
		setHb9999998(hb9999998);
		setHb9999999(hb9999999);
		setRowID_(rowid_);
	}
	
	@Override
	public String toString() {
		return "Hb0101 [" +
				"hb0101001=" + hb0101001 + " " + 
				"hb0101002=" + hb0101002 + " " + 
				"hb0101003=" + hb0101003 + " " + 
				"hb0101004=" + hb0101004 + " " + 
				"hb0101005=" + hb0101005 + " " + 
				"hb0101006=" + DateUtil.getDate(hb0101006) + " " + 
				"hb0101007=" + hb0101007 + " " + 
				"hb0101008=" + DateUtil.getDate(hb0101008) + " " + 
				"hb0101009=" + hb0101009 + " " + 
				"hb0101010=" + hb0101010 + " " + 
				"hb0101011=" + hb0101011 + " " + 
				"hb0101012=" + hb0101012 + " " + 
				"hb0101013=" + hb0101013 + " " + 
				"hb0101014=" + hb0101014 + " " + 
				"hb0101015=" + hb0101015 + " " + 
				"hb0101016=" + hb0101016 + " " + 
				"hb0101017=" + hb0101017 + " " + 
				"hb0101018=" + hb0101018 + " " + 
				"hb0101019=" + DateUtil.getDate(hb0101019) + " " + 
				"hb0101020=" + hb0101020 + " " + 
				"hb0101021=" + DateUtil.getDate(hb0101021) + " " + 
				"hb0101022=" + hb0101022 + " " + 
				"hb0101023=" + DateUtil.getDate(hb0101023) + " " + 
				"hb9999997=" + hb9999997 + " " + 
				"hb9999998=" + hb9999998 + " " + 
				"hb9999999=" + hb9999999 + " " + 
        "]";
	}

}



