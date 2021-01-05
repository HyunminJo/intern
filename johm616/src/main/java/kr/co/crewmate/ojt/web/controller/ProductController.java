package kr.co.crewmate.ojt.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
import kr.co.crewmate.ojt.model.ProductOptionSelect;
import kr.co.crewmate.ojt.model.ProductOptionStock;
import kr.co.crewmate.ojt.model.ProductPrice;
import kr.co.crewmate.ojt.model.ProductSearchWord;
import kr.co.crewmate.ojt.model.Vendor;
import kr.co.crewmate.ojt.model.base.Result;
import kr.co.crewmate.ojt.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * 
     * 조회
     *
     * @since 2020. 11. 09.
     * @author johm616
     *
     * @param model
     * @param product
     * @return
     */
    @RequestMapping({ "/product/product/popup", "/product/product", "/sample/productSample" })
    public String categoryParentList(Model model, Category category) {

        // 업체
        List<Vendor> vendorList = productService.getVendorList();
        model.addAttribute("vendorList", vendorList);
        // 원산지
        List<OriginCode> originList = productService.getOriginList();
        model.addAttribute("originList", originList);
        // 상품 분류정보(상위)
        List<Category> categoryList = productService.getCategoryParentList();
        model.addAttribute("categoryList", categoryList);
        // 정보고시정보
        List<FtcInformation> ftcInfo = productService.getFtcInfomation();
        model.addAttribute("ftcInfo", ftcInfo);

        return "/sample/productSample";
    }

    /**
     * 
     * 상품 분류정보
     *
     * @since 2020. 11. 03.
     * @author johm616
     *
     * @param model
     * @param product
     * @return
     */
    @ResponseBody
    @RequestMapping("/product/listCategoryForSelect")
    public Result productClassifyCategoryList(Model model, Category category) {

        Result result = new Result(1);
        List<Category> html = productService.getClassityCategoryList(category);

        if (html.size() < 1) {
            return result = new Result(-1);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("list", html);
        result.setInfoMap(map);

        model.addAttribute("html", html);
        return result;
    }

    /**
     * 
     * 브랜드 팝업 리스트
     *
     * @since 2020. 11. 06.
     * @author johm616
     *
     * @param model
     * @param product
     * @return
     */
    @RequestMapping({ "/product/brandList/popup", "/prduct/brandList" })
    public String addSelectCategory(Model model, Brand brand) {

        Page<Brand> brandList = productService.getBrandList(brand);
        model.addAttribute("brandList", brandList);

        return "/sample/brandList";
    }

    /**
     * 
     * 정보고시정보 리스트
     *
     * @since 2020. 11. 06.
     * @author johm616
     *
     * @param model
     * @param product
     * @return
     */
    @ResponseBody
    @RequestMapping("/product/getFtcInformationForPrdtCode")
    public Result getFtcInformationForPrdtCode(Model model, FtcInformation ftcInfo) {

        Result result = new Result(1);
        List<FtcInformation> list = productService.getFtcInformationForPrdtCode(ftcInfo);
        Map<String, Object> map = new HashMap<>();

        map.put("list", list);
        result.setInfoMap(map);
        model.addAttribute("html", list);

        return result;
    }

    /**
     * 
     * 관련상품 팝업 리스트
     *
     * @since 2020. 11. 16.
     * @author johm616
     *
     * @param model
     * @param product
     * @return
     */
    @RequestMapping({ "/product/productPopupList/popup", "/product/productList" })
    public String productPopup(Model model, Product product) {
        String stateCode = "";
        String array[];
        if (product.getPrdtStatCode() != null) {
            array = product.getPrdtStatCode().split(",");
            stateCode += "(";
            for (int i = 0; i < array.length; i++) {
                stateCode += "'" + array[i] + "'";
                if (i != array.length - 1) {
                    stateCode += ", ";
                }
            }
            stateCode += ")";
            product.setPrdtStatCode(stateCode);
        }

        if (product.getSelectCategory() != null) {
            product.setSelectCategory(product.getSelectCategorys().get(product.getSelectCategorys().size() - 1));
        }
        System.out.println(product.getDispYn());

        Page<Product> productList = productService.getProductList(product);
        List<Category> categoryList = productService.getCategoryParentList();
        List<Vendor> vendorList = productService.getVendorList();
        model.addAttribute("productList", productList);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("vendorList", vendorList);

        return "/sample/productPopupList";
    }

    /**
     * 
     * 관련상품 팝업 리스트
     *
     * @since 2020. 11. 16.
     * @author johm616
     *
     * @param model
     * @param product
     * @return
     */
    @ResponseBody
    @RequestMapping("/product/insertProduct")
    public Result insertProduct(MultipartHttpServletRequest mrequest, Product product, ProductCategory prdtCategory,
            ProductFTCInfo prdtFtcInfo, ProductIcon prdtIcon, ProductImage prdtImg,
            ProductOptionDetail prdtOptionDetail, ProductOptionMaster prdtOptionMaster,
            ProductOptionSelect prdtOptionSelect, ProductOptionStock prdtOptionStock, ProductPrice prdtPrice,
            ProductSearchWord prdtSearchWord, ConnectionProduct connectPrdt, List<MultipartFile> files) {
        Result result = new Result(1);

        // validate
        // 업체
        if (product.getVndrCntrtId() == null || product.getVndrCntrtId().length() < 1) {
            result.setMessage("업체를 선택하셔야 합니다.");
            result.setResultCode(-1);
            return result;
        }
        // 영문
        if (product.getPrdtEngName() == null || product.getPrdtEngName().length() < 1) {
            result.setMessage("영문상품명을 입력하셔야 합니다.");
            result.setResultCode(-1);
            return result;
        }
        // 브랜드
        if (product.getBrandId() == null || product.getBrandId().length() < 1) {
            result.setMessage("브랜드를 선택하셔야 합니다.");
            result.setResultCode(-1);
            return result;
        }
        if (product.getCooCode() == null || product.getCooCode().length() < 1) {
            result.setMessage("원산지를 선택하셔야 합니다.");
            result.setResultCode(-1);
            return result;
        }
        // 제조사
        if (product.getMnftrName() == null || product.getMnftrName().length() < 1) {
            result.setMessage("제조사는 입력하셔야 합니다.");
            result.setResultCode(-1);
            return result;
        }
        if (prdtIcon.getUpIconCode() != null && prdtIcon.getDownIconCode() != null) {
            // 상단아이콘
            if (prdtIcon.getUpIconCode().length > 1) {
                result.setMessage("상단아이콘은 최대 1개까지만 가능합니다.");
                result.setResultCode(-1);
                return result;
            }
            // 하단아이콘
            if (prdtIcon.getDownIconCode().length > 1) {
                result.setMessage("하단아이콘은 최대 1개까지만 가능합니다.");
                result.setResultCode(-1);
                return result;
            }
        }
        // 상품분류
        if (prdtCategory.getCtgrIds().length < 1) {
            result.setMessage("상품분류는 1개 이상 있어야합니다.");
            result.setResultCode(-1);
            return result;
        } else {
            if (prdtCategory.getStdCtrgYnId().length() == 0) {
                result.setMessage("기준상품분류가 있어야합니다.");
                result.setResultCode(-1);
                return result;
            }
        }
        // 정상가 입력
        if (product.getPrdtSellPrice() == null || product.getPrdtSellPrice().length() < 1) {
            result.setResultCode(-1);
            return result;
        }
        // 판매가 입력
        if (prdtPrice.getDscntErpSellPrice() == null || prdtPrice.getDscntErpSellPrice().length() < 1) {
            result.setResultCode(-1);
            return result;
        }
        // 최소구매수량
        if (product.getMinBuyCount() == null || product.getMinBuyCount().length() < 1) {
            result.setResultCode(-1);
            return result;
        }
        // 최대구매수량
        if (product.getMaxBuyCount() == null || product.getMaxBuyCount().length() < 1) {
            result.setResultCode(-1);
            return result;
        }
        // 관련상품 있는데 선택된 값이 없을때
        if (product.getCntrPrdtUseYn().equals("true")) {
            if (connectPrdt.getCntrPrdtCodes().length < 1) {
                result.setResultCode(-1);
                return result;
            }
        }
        // 메인이미지 필수
        if (mrequest.getFile("prdtImageFile01") == null) {
            result.setResultCode(-1);
            return result;
        }
        // 옵션을 안쓸때 재고 수량 생략하거나 음수로 못줌
        // 옵션을 사용할때 하나 이상의 옵션을 선택해줘야함
        if (product.getOptnUseYn().equals("false")) {
            if (prdtOptionStock.getNoOptionStockCount() == null || prdtOptionStock.getNoOptionStockCount().length() < 1
                    || Integer.parseInt(prdtOptionStock.getNoOptionStockCount()) < 0) {
                result.setResultCode(-1);
                return result;
            }
        } else {
            if (prdtOptionSelect.getSelectStockIndex() == null || prdtOptionSelect.getSelectStockIndex().length < 1) {
                System.out.println("I");
                result.setResultCode(-1);
                return result;
            }
        }

        MultipartFile multipartfile1 = mrequest.getFile("prdtImageFile01");
        MultipartFile multipartfile2 = mrequest.getFile("prdtImageFile02");
        MultipartFile multipartfile3 = mrequest.getFile("prdtImageFile03");
        MultipartFile multipartfile4 = mrequest.getFile("prdtImageFile04");
        MultipartFile multipartfile5 = mrequest.getFile("prdtImageFile05");
        MultipartFile multipartfile6 = mrequest.getFile("prdtImageFile06");
        MultipartFile multipartfile7 = mrequest.getFile("prdtImageFile07");

        List<MultipartFile> multipartFileList = new ArrayList<MultipartFile>();

        multipartFileList.add(multipartfile1);
        multipartFileList.add(multipartfile2);
        multipartFileList.add(multipartfile3);
        multipartFileList.add(multipartfile4);
        multipartFileList.add(multipartfile5);
        multipartFileList.add(multipartfile6);
        multipartFileList.add(multipartfile7);

        Date today = new Date();
        String dateFormat = DateFormatUtils.format(today, "yyyy-MM-dd HH:mm:ss");
        String dateFormat2 = DateFormatUtils.format(today, "yyyyMMdd");
        product.setPrmtDtm(dateFormat);
        product.setRgstDtm(dateFormat);
        product.setLastModDtm(dateFormat);
        prdtImg.setRgstDtm(dateFormat);
        prdtFtcInfo.setRgstDtm(dateFormat);
        prdtPrice.setRgstDtm(dateFormat);
        prdtPrice.setDscntStartDt(dateFormat2);
        prdtPrice.setDscntEndDt("99991231");

        product.setPrdtPrmtCode("W");
        try {
            productService.insertProduct(product, prdtCategory, prdtFtcInfo, prdtIcon, prdtImg, prdtOptionDetail,
                    prdtOptionMaster, prdtOptionSelect, prdtOptionStock, prdtPrice, prdtSearchWord, connectPrdt,
                    multipartFileList, mrequest);
            result.setResultCode(1);
        } catch (Exception e) {
            result.setResultCode(1000);
            result.setMessage("시스템 오류, 관리자에게 문의하세요.");
        }

        return result;
    }

}
