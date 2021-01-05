package kr.co.crewmate.ojt.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import kr.co.crewmate.ojt.dao.base.BaseProductDao;
import kr.co.crewmate.ojt.model.Brand;
import kr.co.crewmate.ojt.model.Category;
import kr.co.crewmate.ojt.model.ConnectionProduct;
import kr.co.crewmate.ojt.model.FtcInformation;
import kr.co.crewmate.ojt.model.OriginCode;
import kr.co.crewmate.ojt.model.Product;
import kr.co.crewmate.ojt.model.ProductCategory;
import kr.co.crewmate.ojt.model.ProductFTCInfo;
import kr.co.crewmate.ojt.model.ProductIcon;
import kr.co.crewmate.ojt.model.ProductImage;
import kr.co.crewmate.ojt.model.ProductOptionDetail;
import kr.co.crewmate.ojt.model.ProductOptionMaster;
import kr.co.crewmate.ojt.model.ProductOptionStock;
import kr.co.crewmate.ojt.model.ProductPrice;
import kr.co.crewmate.ojt.model.ProductSearchWord;
import kr.co.crewmate.ojt.model.Vendor;
import kr.co.crewmate.ojt.model.ProductOptionSelect;

@Repository
public class ProductDao extends BaseProductDao {

    public List<Category> getClassityCategoryList(Category category) {
        return super.selectList("Category.getClassityCategoryList", category);
    }

    public Page<Brand> getBrandList(Brand brand) {
        return super.selectPageList("Product.getBrandList", brand);
    }

    public List<Vendor> getVendorList() {
        return super.selectList("Vendor.getVendorList");
    }

    public List<OriginCode> getOriginList() {
        return super.selectList("Product.getOriginList");
    }

    public List<FtcInformation> getFtcInfomation() {
        return super.selectList("FtcInfo.getFtcInfoList");
    }

    public List<Category> getCategoryParentList() {
        return super.selectList("Category.getCategoryParentList");
    }

    public List<FtcInformation> getFtcInformationForPrdtCode(FtcInformation ftcInfo) {
        return super.selectList("FtcInfo.getFtcInformationForPrdtCode", ftcInfo);
    }

    public Page<Product> getProductList(Product product) {
        return super.selectPageList("Product.getProductList", product);
    }

    public int insertProduct(Product product) {
        return super.insert("Product.insertProduct", product);
    }

    public int insertPrdtCategory(ProductCategory prdtCategory) {
        return super.insert("Product.insertCategory", prdtCategory);        
    }

    public int insertPrdtFtcInfo(ProductFTCInfo prdtFtcInfo) {
        return super.insert("Product.insertFtcInfo", prdtFtcInfo);
    }

    public int insertPrdtIcon(Product product, ProductIcon prdtIcon) {
        return super.insert("Product.insertPrdtIcon", prdtIcon);        
    }

    public int insertPrdtImg(ProductImage prdtImg) {
        return super.insert("Product.insertPrdtImg", prdtImg);        
    }

    public int insertPrdtOptionDetail(ProductOptionDetail prdtOptionDetail) {
        return super.insert("Option.insertPrdtOptionDetail", prdtOptionDetail);        
    }

    public int insertPrdtOptionMaster(ProductOptionMaster prdtOptionMaster) {
        return super.insert("Option.insertPrdtOptionMaster", prdtOptionMaster);        
    }

    public int insertPrdtOptionSelect(ProductOptionSelect prdtOptionSelect) {
        return super.insert("Option.insertPrdtOptionSelect", prdtOptionSelect);        
    }

    public int insertPrdtOptionStock(ProductOptionStock prdtOptionStock) {
        return super.insert("Option.insertPrdtOptionStock", prdtOptionStock);        
    }

    public int insertPrdtPrice(ProductPrice prdtPrice) {
        return super.insert("Product.insertPrdtPrice", prdtPrice);        
    }

    public int insertPrdtSearchWord(ProductSearchWord prdtSearchWord) {
        return super.insert("Product.insertPrdtSearchWord", prdtSearchWord);        
    }

    public int insertConnectPrdt(ConnectionProduct connectPrdt) {
        return super.insert("Product.insertConnectPrdt", connectPrdt);        
    }

    public String selectOneProduct(Product product) {
        return super.selectOne("Product.selectOneProduct", product);
    }
}
