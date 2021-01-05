package kr.co.crewmate.ojt.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import kr.co.crewmate.ojt.model.base.BaseModel;

public class Product extends BaseModel {
                                    
    private String prdtCode;
    private String vndrCntrtId;
    private String brandId;
    private String prdtEngName;
    private String prdtSellPrice;
    private String prdtStatCode;
    private String optnName;
    private String erpColorName;
    private String mnftrName;
    private String cooCode;
    private String rgstDtm;
    private String prdtPrmtCode;
    private String prdtDtlInfo;
    private String cntrPrdtUseYn;
    private String freeGiftUseYn;
    private String lastModAdminId;
    private String lastModDtm;
    private String minBuyCount;
    private String maxBuyCount;
    private String prdtKorName;
    private String dispYn;
    private String srchWord;
    private String prdtStyle;
    private String prdtGbnCode;
    private String prmtDtm;
    private int sellCount;
    private String freeDlvyYn;
    //============================================
    private String brandName;
    private String prdtImagePath;
    private String vndrJoinStatCode;
    private String cntrtStartDt;
    private String cntrtEndDt;
    private String ftcYn;
    private int laveCount;
    private String category;
    private String vndrId;
    private String dscntStartSellPrice;
    private String dscntEndSellPrice;
    private String startDate;
    private String endDate;
    private String sortType;
    private boolean vndrStopPrdtEscp;
    private List<String> selectCategorys;
    private String selectCategory;
    private String mode;
    private List<String> optnMstrNames;
    private String optnMstrName;
    private String optnUseYn;


    /**
     * 옵션마스터아이디(tb_product_option_master)
     */
    private List<String> optnMstrIds;
    /**
     * 옵션마스터아이디 단일(tb_product_option_master)
     */
    private String optnMstrId;
    /**
     * 옵션마스터순서(tb_product_option_master)
     */
    private List<String> optnMstrOrders;
    /**
     * 옵션마스터순서 단일(tb_product_option_master)
     */
    private String optnMstrOrder;
    /**
     * 옵션디테일마스터순서
     */
    private List<Integer> optnDetailMstrOrders;
    /**
     * 옵션아이디(tb_product_option_detail)
     */
    private List<String> optnDetailIds;
    /**
     * 옵션아이디 단일(tb_product_option_detail)
     */
    private String optnDetailId;
    /**
     * 옵션값(tb_product_option_detail)
     */
    private List<String> optnDetailValues;
    /**
     * 옵션값 단일(tb_product_option_detail)
     */
    private String optnDetailValue;
    /**
     * 옵션금액(tb_product_option_detail)
     */
    private List<String> optnDetailAmts;
    /**
     * 옵션금액 단일(tb_product_option_detail)
     */
    private String optnDetailAmt;
    /**
     * 옵션순서(tb_product_option_detail)
     */
    private int optnOrder;
    /**
     * 재고순번(tb_product_option_stock)
     */
    private int stockSeq;
    /**
     * 재고수량(tb_product_option_stock)
     */
    private List<String> selectedStockCounts;
    /**
     * 재고수량 단일(tb_product_option_stock)
     */
    private String selectedStockCount;
    /**
     * 전시여부(tb_product_option_stock)
     */
    private List<String> selectedOptnDispYns;
    /**
     * 전시여부 단일(tb_product_option_stock)
     */
    private String selectedOptnDispYn;
    /**
     * 옵션사용 여부
     */
    private List<Integer> selectStockIndex;
    /**
     * 공정위정보일련번호(tb_product_ftc_info)
     */
    private List<Integer> ftcInfoSeqs;
    /**
     * 공정위정보일련번호 단일(tb_product_ftc_info)
     */
    private int ftcInfoSeq;
    /**
     * 정보고시내용(tb_product_ftc_info)
     */
    private List<String> infoNotcConts;
    /**
     * 정보고시내용 단일(tb_product_ftc_info)
     */
    private String infoNotcCont;
    /**
     * 관리자아이디(tb_product_ftc_info)
     */
    private List<String> adminIds;
    /**
     * 관리자아이디 단일(tb_product_ftc_info)
     */
    private String adminId;
    /**
     * 카테고리아이디(tb_product_category)
     */
    private List<String> ctgrIds;
    /**
     * 카테고리아이디 단일(tb_product_category)
     */
    private String ctgrId;
    /**
     * 기준카테고리여부(tb_product_category)
     */
    private String stdCtgrYnId;
    /**
     * 상단아이콘(tb_product_icon)
     */
    private List<String> upIconCode;
    /**
     * 하단아이콘(tb_product_icon)
     */
    private List<String> downIconCode;
    /**
     * 아이콘아이디(tb_product_icon)
     */
    private String iconId;
    /**
     * 상품할인가격(tb_product_price)
     */
    private String dscntErpSellPrice;
    /**
     * 상품가격일련번호(tb_product_price)
     */
    private int prdtPriceSeq;
    /**
     * 검색일련번호(tb_product_search_word)
     */
    private int srchSeq;
    /**
     * 검색단어(tb_product_search_word)
     */
    private String[] srchWords;
    /**
     * 관련상품코드(tb_connection_product)
     */
    private List<String> cntrPrdtCodes;
    /**
     * 관련상품코드 단일(tb_connection_product)
     */
    private String cntrPrdtCode;
    /**
     * 상품이미지코드(tb_product_image)
     */
    private List<String> prdtImageCodes;
    /**
     * 상품이미지코드 단일(tb_product_image)
     */
    private String prdtImageCode;
    /**
     * 이미지주소(tb_product_image)
     */
    private List<String> prdtImagePaths;

    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

    

    public Product(String prdtCode, String vndrCntrtId, String brandId, String prdtEngName, String prdtSellPrice,
            String prdtStatCode, String optnName, String erpColorName, String mnftrName, String cooCode, String rgstDtm,
            String prdtPrmtCode, String prdtDtlInfo, String cntrPrdtUseYn, String freeGiftUseYn, String lastModAdminId,
            String lastModDtm, String minBuyCount, String maxBuyCount, String prdtKorName, String dispYn,
            String srchWord, String prdtStyle, String prdtGbnCode, String prmtDtm, int sellCount, String freeDlvyYn,
            String brandName, String prdtImagePath, String vndrJoinStatCode, String cntrtStartDt, String cntrtEndDt,
            String ftcYn, int laveCount, String category, String vndrId, String dscntStartSellPrice,
            String dscntEndSellPrice, String startDate, String endDate, String sortType, boolean vndrStopPrdtEscp,
            List<String> selectCategorys, String selectCategory, String mode, List<String> optnMstrNames,
            String optnMstrName, String optnUseYn, List<String> optnMstrIds, String optnMstrId,
            List<String> optnMstrOrders, String optnMstrOrder, List<Integer> optnDetailMstrOrders,
            List<String> optnDetailIds, String optnDetailId, List<String> optnDetailValues, String optnDetailValue,
            List<String> optnDetailAmts, String optnDetailAmt, int optnOrder, int stockSeq,
            List<String> selectedStockCounts, String selectedStockCount, List<String> selectedOptnDispYns,
            String selectedOptnDispYn, List<Integer> selectStockIndex, List<Integer> ftcInfoSeqs, int ftcInfoSeq,
            List<String> infoNotcConts, String infoNotcCont, List<String> adminIds, String adminId,
            List<String> ctgrIds, String ctgrId, String stdCtgrYnId, List<String> upIconCode, List<String> downIconCode,
            String iconId, String dscntErpSellPrice, int prdtPriceSeq, int srchSeq, String[] srchWords,
            List<String> cntrPrdtCodes, String cntrPrdtCode, List<String> prdtImageCodes, String prdtImageCode,
            List<String> prdtImagePaths) {
        super();
        this.prdtCode = prdtCode;
        this.vndrCntrtId = vndrCntrtId;
        this.brandId = brandId;
        this.prdtEngName = prdtEngName;
        this.prdtSellPrice = prdtSellPrice;
        this.prdtStatCode = prdtStatCode;
        this.optnName = optnName;
        this.erpColorName = erpColorName;
        this.mnftrName = mnftrName;
        this.cooCode = cooCode;
        this.rgstDtm = rgstDtm;
        this.prdtPrmtCode = prdtPrmtCode;
        this.prdtDtlInfo = prdtDtlInfo;
        this.cntrPrdtUseYn = cntrPrdtUseYn;
        this.freeGiftUseYn = freeGiftUseYn;
        this.lastModAdminId = lastModAdminId;
        this.lastModDtm = lastModDtm;
        this.minBuyCount = minBuyCount;
        this.maxBuyCount = maxBuyCount;
        this.prdtKorName = prdtKorName;
        this.dispYn = dispYn;
        this.srchWord = srchWord;
        this.prdtStyle = prdtStyle;
        this.prdtGbnCode = prdtGbnCode;
        this.prmtDtm = prmtDtm;
        this.sellCount = sellCount;
        this.freeDlvyYn = freeDlvyYn;
        this.brandName = brandName;
        this.prdtImagePath = prdtImagePath;
        this.vndrJoinStatCode = vndrJoinStatCode;
        this.cntrtStartDt = cntrtStartDt;
        this.cntrtEndDt = cntrtEndDt;
        this.ftcYn = ftcYn;
        this.laveCount = laveCount;
        this.category = category;
        this.vndrId = vndrId;
        this.dscntStartSellPrice = dscntStartSellPrice;
        this.dscntEndSellPrice = dscntEndSellPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sortType = sortType;
        this.vndrStopPrdtEscp = vndrStopPrdtEscp;
        this.selectCategorys = selectCategorys;
        this.selectCategory = selectCategory;
        this.mode = mode;
        this.optnMstrNames = optnMstrNames;
        this.optnMstrName = optnMstrName;
        this.optnUseYn = optnUseYn;
        this.optnMstrIds = optnMstrIds;
        this.optnMstrId = optnMstrId;
        this.optnMstrOrders = optnMstrOrders;
        this.optnMstrOrder = optnMstrOrder;
        this.optnDetailMstrOrders = optnDetailMstrOrders;
        this.optnDetailIds = optnDetailIds;
        this.optnDetailId = optnDetailId;
        this.optnDetailValues = optnDetailValues;
        this.optnDetailValue = optnDetailValue;
        this.optnDetailAmts = optnDetailAmts;
        this.optnDetailAmt = optnDetailAmt;
        this.optnOrder = optnOrder;
        this.stockSeq = stockSeq;
        this.selectedStockCounts = selectedStockCounts;
        this.selectedStockCount = selectedStockCount;
        this.selectedOptnDispYns = selectedOptnDispYns;
        this.selectedOptnDispYn = selectedOptnDispYn;
        this.selectStockIndex = selectStockIndex;
        this.ftcInfoSeqs = ftcInfoSeqs;
        this.ftcInfoSeq = ftcInfoSeq;
        this.infoNotcConts = infoNotcConts;
        this.infoNotcCont = infoNotcCont;
        this.adminIds = adminIds;
        this.adminId = adminId;
        this.ctgrIds = ctgrIds;
        this.ctgrId = ctgrId;
        this.stdCtgrYnId = stdCtgrYnId;
        this.upIconCode = upIconCode;
        this.downIconCode = downIconCode;
        this.iconId = iconId;
        this.dscntErpSellPrice = dscntErpSellPrice;
        this.prdtPriceSeq = prdtPriceSeq;
        this.srchSeq = srchSeq;
        this.srchWords = srchWords;
        this.cntrPrdtCodes = cntrPrdtCodes;
        this.cntrPrdtCode = cntrPrdtCode;
        this.prdtImageCodes = prdtImageCodes;
        this.prdtImageCode = prdtImageCode;
        this.prdtImagePaths = prdtImagePaths;
    }



    public String getPrdtCode() {
        return prdtCode;
    }

    public void setPrdtCode(String prdtCode) {
        this.prdtCode = prdtCode;
    }

    public String getVndrCntrtId() {
        return vndrCntrtId;
    }

    public void setVndrCntrtId(String vndrCntrtId) {
        this.vndrCntrtId = vndrCntrtId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getPrdtEngName() {
        return prdtEngName;
    }

    public void setPrdtEngName(String prdtEngName) {
        this.prdtEngName = prdtEngName;
    }

    public String getPrdtSellPrice() {
        return prdtSellPrice;
    }

    public void setPrdtSellPrice(String prdtSellPrice) {
        this.prdtSellPrice = prdtSellPrice;
    }

    public String getPrdtStatCode() {
        return prdtStatCode;
    }

    public void setPrdtStatCode(String prdtStatCode) {
        this.prdtStatCode = prdtStatCode;
    }

    public String getOptnName() {
        return optnName;
    }

    public void setOptnName(String optnName) {
        this.optnName = optnName;
    }

    public String getErpColorName() {
        return erpColorName;
    }

    public void setErpColorName(String erpColorName) {
        this.erpColorName = erpColorName;
    }

    public String getMnftrName() {
        return mnftrName;
    }

    public void setMnftrName(String mnftrName) {
        this.mnftrName = mnftrName;
    }

    public String getCooCode() {
        return cooCode;
    }

    public void setCooCode(String cooCode) {
        this.cooCode = cooCode;
    }

    public String getRgstDtm() {
        return rgstDtm;
    }

    public void setRgstDtm(String rgstDtm) {
        this.rgstDtm = rgstDtm;
    }

    public String getPrdtPrmtCode() {
        return prdtPrmtCode;
    }

    public void setPrdtPrmtCode(String prdtPrmtCode) {
        this.prdtPrmtCode = prdtPrmtCode;
    }

    public String getPrdtDtlInfo() {
        return prdtDtlInfo;
    }

    public void setPrdtDtlInfo(String prdtDtlInfo) {
        this.prdtDtlInfo = prdtDtlInfo;
    }

    public String getCntrPrdtUseYn() {
        return cntrPrdtUseYn;
    }

    public void setCntrPrdtUseYn(String cntrPrdtUseYn) {
        this.cntrPrdtUseYn = cntrPrdtUseYn;
    }

    public String getFreeGiftUseYn() {
        return freeGiftUseYn;
    }

    public void setFreeGiftUseYn(String freeGiftUseYn) {
        this.freeGiftUseYn = freeGiftUseYn;
    }

    public String getLastModAdminId() {
        return lastModAdminId;
    }

    public void setLastModAdminId(String lastModAdminId) {
        this.lastModAdminId = lastModAdminId;
    }

    public String getLastModDtm() {
        return lastModDtm;
    }

    public void setLastModDtm(String lastModDtm) {
        this.lastModDtm = lastModDtm;
    }

    public String getMinBuyCount() {
        return minBuyCount;
    }

    public void setMinBuyCount(String minBuyCount) {
        this.minBuyCount = minBuyCount;
    }

    public String getMaxBuyCount() {
        return maxBuyCount;
    }

    public void setMaxBuyCount(String maxBuyCount) {
        this.maxBuyCount = maxBuyCount;
    }

    public String getPrdtKorName() {
        return prdtKorName;
    }

    public void setPrdtKorName(String prdtKorName) {
        this.prdtKorName = prdtKorName;
    }

    public String getDispYn() {
        return dispYn;
    }

    public void setDispYn(String dispYn) {
        this.dispYn = dispYn;
    }

    public String getSrchWord() {
        return srchWord;
    }

    public void setSrchWord(String srchWord) {
        this.srchWord = srchWord;
    }

    public String getPrdtStyle() {
        return prdtStyle;
    }

    public void setPrdtStyle(String prdtStyle) {
        this.prdtStyle = prdtStyle;
    }

    public String getPrdtGbnCode() {
        return prdtGbnCode;
    }

    public void setPrdtGbnCode(String prdtGbnCode) {
        this.prdtGbnCode = prdtGbnCode;
    }

    public String getPrmtDtm() {
        return prmtDtm;
    }

    public void setPrmtDtm(String prmtDtm) {
        this.prmtDtm = prmtDtm;
    }

    public int getSellCount() {
        return sellCount;
    }

    public void setSellCount(int sellCount) {
        this.sellCount = sellCount;
    }

    public String getFreeDlvyYn() {
        return freeDlvyYn;
    }

    public void setFreeDlvyYn(String freeDlvyYn) {
        this.freeDlvyYn = freeDlvyYn;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getPrdtImagePath() {
        return prdtImagePath;
    }

    public void setPrdtImagePath(String prdtImagePath) {
        this.prdtImagePath = prdtImagePath;
    }

    public String getVndrJoinStatCode() {
        return vndrJoinStatCode;
    }

    public void setVndrJoinStatCode(String vndrJoinStatCode) {
        this.vndrJoinStatCode = vndrJoinStatCode;
    }

    public String getCntrtStartDt() {
        return cntrtStartDt;
    }

    public void setCntrtStartDt(String cntrtStartDt) {
        this.cntrtStartDt = cntrtStartDt;
    }

    public String getCntrtEndDt() {
        return cntrtEndDt;
    }

    public void setCntrtEndDt(String cntrtEndDt) {
        this.cntrtEndDt = cntrtEndDt;
    }

    public String getFtcYn() {
        return ftcYn;
    }

    public void setFtcYn(String ftcYn) {
        this.ftcYn = ftcYn;
    }

    public int getLaveCount() {
        return laveCount;
    }

    public void setLaveCount(int laveCount) {
        this.laveCount = laveCount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVndrId() {
        return vndrId;
    }

    public void setVndrId(String vndrId) {
        this.vndrId = vndrId;
    }

    public String getDscntStartSellPrice() {
        return dscntStartSellPrice;
    }

    public void setDscntStartSellPrice(String dscntStartSellPrice) {
        this.dscntStartSellPrice = dscntStartSellPrice;
    }

    public String getDscntEndSellPrice() {
        return dscntEndSellPrice;
    }

    public void setDscntEndSellPrice(String dscntEndSellPrice) {
        this.dscntEndSellPrice = dscntEndSellPrice;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public boolean isVndrStopPrdtEscp() {
        return vndrStopPrdtEscp;
    }

    public void setVndrStopPrdtEscp(boolean vndrStopPrdtEscp) {
        this.vndrStopPrdtEscp = vndrStopPrdtEscp;
    }

    public List<String> getSelectCategorys() {
        return selectCategorys;
    }

    public void setSelectCategorys(List<String> selectCategorys) {
        this.selectCategorys = selectCategorys;
    }

    public String getSelectCategory() {
        return selectCategory;
    }

    public void setSelectCategory(String selectCategory) {
        this.selectCategory = selectCategory;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<String> getOptnMstrNames() {
        return optnMstrNames;
    }

    public void setOptnMstrNames(List<String> optnMstrNames) {
        this.optnMstrNames = optnMstrNames;
    }

    public String getOptnMstrName() {
        return optnMstrName;
    }

    public void setOptnMstrName(String optnMstrName) {
        this.optnMstrName = optnMstrName;
    }

    public List<String> getOptnMstrIds() {
        return optnMstrIds;
    }

    public void setOptnMstrIds(List<String> optnMstrIds) {
        this.optnMstrIds = optnMstrIds;
    }

    public String getOptnMstrId() {
        return optnMstrId;
    }

    public void setOptnMstrId(String optnMstrId) {
        this.optnMstrId = optnMstrId;
    }

    public List<String> getOptnMstrOrders() {
        return optnMstrOrders;
    }

    public void setOptnMstrOrders(List<String> optnMstrOrders) {
        this.optnMstrOrders = optnMstrOrders;
    }

    public String getOptnMstrOrder() {
        return optnMstrOrder;
    }

    public void setOptnMstrOrder(String optnMstrOrder) {
        this.optnMstrOrder = optnMstrOrder;
    }

    public List<Integer> getOptnDetailMstrOrders() {
        return optnDetailMstrOrders;
    }

    public void setOptnDetailMstrOrders(List<Integer> optnDetailMstrOrders) {
        this.optnDetailMstrOrders = optnDetailMstrOrders;
    }

    public List<String> getOptnDetailIds() {
        return optnDetailIds;
    }

    public void setOptnDetailIds(List<String> optnDetailIds) {
        this.optnDetailIds = optnDetailIds;
    }

    public String getOptnDetailId() {
        return optnDetailId;
    }

    public void setOptnDetailId(String optnDetailId) {
        this.optnDetailId = optnDetailId;
    }

    public List<String> getOptnDetailValues() {
        return optnDetailValues;
    }

    public void setOptnDetailValues(List<String> optnDetailValues) {
        this.optnDetailValues = optnDetailValues;
    }

    public String getOptnDetailValue() {
        return optnDetailValue;
    }

    public void setOptnDetailValue(String optnDetailValue) {
        this.optnDetailValue = optnDetailValue;
    }

    public List<String> getOptnDetailAmts() {
        return optnDetailAmts;
    }

    public void setOptnDetailAmts(List<String> optnDetailAmts) {
        this.optnDetailAmts = optnDetailAmts;
    }

    public String getOptnDetailAmt() {
        return optnDetailAmt;
    }

    public void setOptnDetailAmt(String optnDetailAmt) {
        this.optnDetailAmt = optnDetailAmt;
    }

    public int getOptnOrder() {
        return optnOrder;
    }

    public void setOptnOrder(int optnOrder) {
        this.optnOrder = optnOrder;
    }

    public int getStockSeq() {
        return stockSeq;
    }

    public void setStockSeq(int stockSeq) {
        this.stockSeq = stockSeq;
    }

    public List<String> getSelectedStockCounts() {
        return selectedStockCounts;
    }

    public void setSelectedStockCounts(List<String> selectedStockCounts) {
        this.selectedStockCounts = selectedStockCounts;
    }

    public String getSelectedStockCount() {
        return selectedStockCount;
    }

    public void setSelectedStockCount(String selectedStockCount) {
        this.selectedStockCount = selectedStockCount;
    }

    public List<String> getSelectedOptnDispYns() {
        return selectedOptnDispYns;
    }

    public void setSelectedOptnDispYns(List<String> selectedOptnDispYns) {
        this.selectedOptnDispYns = selectedOptnDispYns;
    }

    public String getSelectedOptnDispYn() {
        return selectedOptnDispYn;
    }

    public void setSelectedOptnDispYn(String selectedOptnDispYn) {
        this.selectedOptnDispYn = selectedOptnDispYn;
    }

    public List<Integer> getSelectStockIndex() {
        return selectStockIndex;
    }

    public void setSelectStockIndex(List<Integer> selectStockIndex) {
        this.selectStockIndex = selectStockIndex;
    }

    public List<Integer> getFtcInfoSeqs() {
        return ftcInfoSeqs;
    }

    public void setFtcInfoSeqs(List<Integer> ftcInfoSeqs) {
        this.ftcInfoSeqs = ftcInfoSeqs;
    }

    public int getFtcInfoSeq() {
        return ftcInfoSeq;
    }

    public void setFtcInfoSeq(int ftcInfoSeq) {
        this.ftcInfoSeq = ftcInfoSeq;
    }

    public List<String> getInfoNotcConts() {
        return infoNotcConts;
    }

    public void setInfoNotcConts(List<String> infoNotcConts) {
        this.infoNotcConts = infoNotcConts;
    }

    public String getInfoNotcCont() {
        return infoNotcCont;
    }

    public void setInfoNotcCont(String infoNotcCont) {
        this.infoNotcCont = infoNotcCont;
    }

    public List<String> getAdminIds() {
        return adminIds;
    }

    public void setAdminIds(List<String> adminIds) {
        this.adminIds = adminIds;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public List<String> getCtgrIds() {
        return ctgrIds;
    }

    public void setCtgrIds(List<String> ctgrIds) {
        this.ctgrIds = ctgrIds;
    }

    public String getCtgrId() {
        return ctgrId;
    }

    public void setCtgrId(String ctgrId) {
        this.ctgrId = ctgrId;
    }

    public String getStdCtgrYnId() {
        return stdCtgrYnId;
    }

    public void setStdCtgrYnId(String stdCtgrYnId) {
        this.stdCtgrYnId = stdCtgrYnId;
    }

    public List<String> getUpIconCode() {
        return upIconCode;
    }

    public void setUpIconCode(List<String> upIconCode) {
        this.upIconCode = upIconCode;
    }

    public List<String> getDownIconCode() {
        return downIconCode;
    }

    public void setDownIconCode(List<String> downIconCode) {
        this.downIconCode = downIconCode;
    }

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }

    public String getDscntErpSellPrice() {
        return dscntErpSellPrice;
    }

    public void setDscntErpSellPrice(String dscntErpSellPrice) {
        this.dscntErpSellPrice = dscntErpSellPrice;
    }

    public int getPrdtPriceSeq() {
        return prdtPriceSeq;
    }

    public void setPrdtPriceSeq(int prdtPriceSeq) {
        this.prdtPriceSeq = prdtPriceSeq;
    }

    public int getSrchSeq() {
        return srchSeq;
    }

    public void setSrchSeq(int srchSeq) {
        this.srchSeq = srchSeq;
    }

    public String[] getSrchWords() {
        return srchWords;
    }

    public void setSrchWords(String[] srchWords) {
        this.srchWords = srchWords;
    }

    public List<String> getCntrPrdtCodes() {
        return cntrPrdtCodes;
    }

    public void setCntrPrdtCodes(List<String> cntrPrdtCodes) {
        this.cntrPrdtCodes = cntrPrdtCodes;
    }

    public String getCntrPrdtCode() {
        return cntrPrdtCode;
    }

    public void setCntrPrdtCode(String cntrPrdtCode) {
        this.cntrPrdtCode = cntrPrdtCode;
    }

    public List<String> getPrdtImageCodes() {
        return prdtImageCodes;
    }

    public void setPrdtImageCodes(List<String> prdtImageCodes) {
        this.prdtImageCodes = prdtImageCodes;
    }

    public String getPrdtImageCode() {
        return prdtImageCode;
    }

    public void setPrdtImageCode(String prdtImageCode) {
        this.prdtImageCode = prdtImageCode;
    }

    public List<String> getPrdtImagePaths() {
        return prdtImagePaths;
    }

    public void setPrdtImagePaths(List<String> prdtImagePaths) {
        this.prdtImagePaths = prdtImagePaths;
    }
    public String getOptnUseYn() {
        return optnUseYn;
    }
    public void setOptnUseYn(String optnUseYn) {
        this.optnUseYn = optnUseYn;
    }
     
}
    