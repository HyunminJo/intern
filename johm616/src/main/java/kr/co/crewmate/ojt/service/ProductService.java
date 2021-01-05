package kr.co.crewmate.ojt.service;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.crewmate.ojt.dao.ProductDao;
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

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    public List<Category> getClassityCategoryList(Category category) {
        return productDao.getClassityCategoryList(category);
    }

    public Page<Brand> getBrandList(Brand brand) {
        return productDao.getBrandList(brand);
    }

    public List<Vendor> getVendorList() {
        return productDao.getVendorList();
    }

    public List<OriginCode> getOriginList() {
        return productDao.getOriginList();
    }

    public List<FtcInformation> getFtcInfomation() {
        return productDao.getFtcInfomation();
    }

    public List<Category> getCategoryParentList() {
        return productDao.getCategoryParentList();
    }

    public List<FtcInformation> getFtcInformationForPrdtCode(FtcInformation ftcInfo) {
        return productDao.getFtcInformationForPrdtCode(ftcInfo);
    }

    public Page<Product> getProductList(Product product) {
        return productDao.getProductList(product);
    }

    public void insertProduct(Product product, ProductCategory prdtCategory, ProductFTCInfo prdtFtcInfo,
            ProductIcon prdtIcon, ProductImage prdtImg, ProductOptionDetail prdtOptionDetail,
            ProductOptionMaster prdtOptionMaster, ProductOptionSelect prdtOptionSelect,
            ProductOptionStock prdtOptionStock, ProductPrice prdtPrice, ProductSearchWord prdtSearchWord,
            ConnectionProduct connectPrdt, List<MultipartFile> files, MultipartHttpServletRequest mrequest) {

        String thisPrdtCode = productDao.selectOneProduct(product);
        product.setPrdtCode(thisPrdtCode);
        prdtCategory.setPrdtCode(thisPrdtCode);
        prdtFtcInfo.setPrdtCode(thisPrdtCode);
        connectPrdt.setCntrPrdtMstrCode(thisPrdtCode);
        prdtIcon.setPrdtCode(thisPrdtCode);
        prdtSearchWord.setPrdtCode(thisPrdtCode);
        prdtOptionStock.setPrdtCode(thisPrdtCode);
        prdtOptionDetail.setPrdtCode(thisPrdtCode);
        prdtOptionMaster.setPrdtCode(thisPrdtCode);
        prdtOptionSelect.setPrdtCode(thisPrdtCode);
        prdtImg.setPrdtCode(thisPrdtCode);
        prdtPrice.setPrdtCode(thisPrdtCode);

        insertProduct(product);
        insertPrdtCategory(prdtCategory);
        insertPrdtFtcInfo(prdtFtcInfo);
        insertPrdtIcon(product, prdtIcon);
        if (product.getOptnUseYn().equals("true")) {
            insertPrdtOptionMaster(prdtOptionMaster, prdtOptionDetail);
            insertPrdtOptionStock(prdtOptionStock, prdtOptionSelect);
        } else {
            prdtOptionMaster.setOptnMstrName("옵션없음");
            prdtOptionStock.setStockSeq("1");
            prdtOptionStock.setStockCount(prdtOptionStock.getNoOptionStockCount());
            prdtOptionStock.setSellCount("0");
            prdtOptionStock.setDispYn("Y");
            prdtOptionStock.setDelYn("N");
            productDao.insertPrdtOptionStock(prdtOptionStock);
        }
        insertPrdtSearchWord(prdtSearchWord);
        insertPrdtPrice(prdtPrice);
        insertConnectPrdt(connectPrdt);

        String tempName = "../resources/static/images/upload";
        String saveDir = mrequest.getSession().getServletContext().getRealPath("/");
        String savePath = saveDir + tempName;
        File dir = new File(savePath);

        if (!dir.exists())
            dir.mkdirs();

        int index = 0;
        for (MultipartFile file : files) {
            if (files.get(index) != null) {
                String subTitle = "";
                String subName = "";
                prdtImg.setPrdtImageCode(String.format("%02d", index + 1));
                String originName = file.getOriginalFilename();
                String ext = originName.substring(originName.lastIndexOf(".") + 1);
                String secondName = thisPrdtCode + "_" + prdtImg.getPrdtImageCode() + "." + ext;
                int width = 0, height = 0;

                if (!"".equals(prdtImg.getPrdtImagePaths()) || (index == 5 || index == 6)) {
                    switch (index) {
                    case 0:
                        width = 400;
                        height = 400;
                        subName = "title";
                        subTitle = "_title.";
                        secondName = thisPrdtCode + subTitle + ext;
                        break;
                    case 1:
                        width = 400;
                        height = 400;
                        subName = "sub1";
                        subTitle = "_sub1.";
                        secondName = thisPrdtCode + subTitle + ext;
                        break;
                    case 2:
                        width = 400;
                        height = 400;
                        subName = "sub2.";
                        subTitle = "_sub2.";
                        secondName = thisPrdtCode + subTitle + ext;
                        break;
                    case 3:
                        width = 400;
                        height = 400;
                        subName = "sub3.";
                        subTitle = "_sub3.";
                        secondName = thisPrdtCode + subTitle + ext;
                        break;
                    case 4:
                        width = 400;
                        height = 400;
                        subName = "sub4.";
                        subTitle = "_sub4.";
                        secondName = thisPrdtCode + subTitle + ext;
                        break;
                    case 5:
                        width = 200;
                        height = 200;
                        subName = "main.";
                        subTitle = "_main.";
                        secondName = thisPrdtCode + subTitle + ext;
                        break;
                    case 6:
                        width = 150;
                        height = 150;
                        subName = "list.";
                        subTitle = "_list.";
                        secondName = thisPrdtCode + subTitle + ext;
                        break;
                    }
                }
                try {
                    if (file != null) {
                        resize(file, width, height, savePath, secondName, ext);
                    }
                } catch (IllegalStateException | IOException e) {
                    e.printStackTrace();
                }
                String rndNum = String.format("%03d", (int) (Math.random() * 1000));
                String imagePath = "/demoshop/upload/" + subName + "/" + rndNum + "/" + secondName;
                prdtImg.setPrdtImagePath(imagePath);
                productDao.insertPrdtImg(prdtImg);
            }
            index++;
        }
        if (files.get(5) == null) {
            String subName = "main";
            String originName = files.get(0).getOriginalFilename();
            String ext = originName.substring(originName.lastIndexOf(".") + 1);
            String secondName = thisPrdtCode + "_" + prdtImg.getPrdtImageCode() + subName + "." + ext;
            prdtImg.setPrdtImageCode("06");
            int width = 200, height = 200;
            try {
                resize(files.get(0), width, height, savePath, secondName, ext);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
            String rndNum = String.format("%03d", (int) (Math.random() * 1000));
            String imagePath = "/demoshop/upload/" + subName + "/" + rndNum + "/" + secondName;
            prdtImg.setPrdtImagePath(imagePath);
            productDao.insertPrdtImg(prdtImg);
        }
        if (files.get(6) == null) {
            String subName = "list";
            String originName = files.get(0).getOriginalFilename();
            String ext = originName.substring(originName.lastIndexOf(".") + 1);
            String secondName = thisPrdtCode + "_" + prdtImg.getPrdtImageCode() + subName + "." + ext;
            prdtImg.setPrdtImageCode("07");
            int width = 150, height = 150;
            try {
                resize(files.get(0), width, height, savePath, secondName, ext);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
            String rndNum = String.format("%03d", (int) (Math.random() * 1000));
            String imagePath = "/demoshop/upload/" + subName + "/" + rndNum + "/" + secondName;
            prdtImg.setPrdtImagePath(imagePath);
            productDao.insertPrdtImg(prdtImg);
        }
    }

    // 상품 기본 정보
    private void insertProduct(Product product) {
        product.setLastModAdminId("admin");
        if (product.getCntrPrdtUseYn() == "true") {
            product.setCntrPrdtUseYn("Y");
        } else {
            product.setCntrPrdtUseYn("N");
        }
        if (product.getDispYn() == "true") {
            product.setDispYn("Y");
        } else {
            product.setDispYn("N");
        }
        if (product.getFreeDlvyYn() == "true") {
            product.setFreeDlvyYn("Y");
        } else {
            product.setFreeDlvyYn("N");
        }
        if (product.getFreeGiftUseYn() == "true") {
            product.setFreeGiftUseYn("Y");
        } else {
            product.setFreeGiftUseYn("N");
        }
        productDao.insertProduct(product);
    }

    // 상품 분류
    private void insertPrdtCategory(ProductCategory prdtCategory) {
        for (int i = 0; i < prdtCategory.getCtgrIds().length; i++) {
            prdtCategory.setCtgrId(prdtCategory.getCtgrIds()[i]);
            if (prdtCategory.getStdCtrgYnId().equals(prdtCategory.getCtgrIds()[i])) {
                prdtCategory.setStdCtgrYn("Y");
            } else {
                prdtCategory.setStdCtgrYn("N");
            }
        }
        productDao.insertPrdtCategory(prdtCategory);
    }

    // 상품 정보고시
    private void insertPrdtFtcInfo(ProductFTCInfo prdtFtcInfo) {
        prdtFtcInfo.setAdminId("admin");

        if (prdtFtcInfo.getFtcInfoSeqs() != null) {
            for (int i = 0; i < prdtFtcInfo.getFtcInfoSeqs().length; i++) {
                prdtFtcInfo.setFtcInfoSeq(prdtFtcInfo.getFtcInfoSeqs()[i]);
                prdtFtcInfo.setDispYn(prdtFtcInfo.getDispYns()[i]);
                if (prdtFtcInfo.getDispYn() == "true") {
                    prdtFtcInfo.setDispYn("Y");
                } else {
                    prdtFtcInfo.setDispYn("N");
                }
                prdtFtcInfo.setInfoNotcCont(prdtFtcInfo.getInfoNotcConts()[i]);
                productDao.insertPrdtFtcInfo(prdtFtcInfo);
            }
        }
    }

    // 아이콘
    private void insertPrdtIcon(Product product, ProductIcon prdtIcon) {
        if (prdtIcon.getUpIconCode() != null && prdtIcon.getDownIconCode() != null) {
            if (prdtIcon.getUpIconCode().length > 1) {
                for (int i = 0; i < prdtIcon.getUpIconCode().length; i++) {
                    prdtIcon.setIconId(prdtIcon.getUpIconCode()[i]);
                    productDao.insertPrdtIcon(product, prdtIcon);
                }
            }
            if (prdtIcon.getDownIconCode().length > 1) {
                for (int i = 0; i < prdtIcon.getDownIconCode().length; i++) {
                    prdtIcon.setIconId(prdtIcon.getDownIconCode()[i]);
                    productDao.insertPrdtIcon(product, prdtIcon);
                }
            }
        }
    }

    // 가격
    private void insertPrdtPrice(ProductPrice prdtPrice) {
        if (prdtPrice.getDscntErpSellPrice() != prdtPrice.getPrdtDscntPrice()) {
            prdtPrice.setPrdtPriceSeq(prdtPrice.getPrdtPriceSeq());
            prdtPrice.setPrdtDscntPrice(prdtPrice.getDscntErpSellPrice());
            productDao.insertPrdtPrice(prdtPrice);
        }
    }

    // 키워드
    private void insertPrdtSearchWord(ProductSearchWord prdtSearchWord) {
        if (prdtSearchWord.getSrchWord().length() != 0) {
            String[] srchWords = prdtSearchWord.getSrchWord().split(",");
            for (int i = 0; i < srchWords.length; i++) {
                prdtSearchWord.setSrchWord(srchWords[i]);
                prdtSearchWord.setSrchSeq(i + 1);
                productDao.insertPrdtSearchWord(prdtSearchWord);
            }
        }
    }

    // 관련상품
    private void insertConnectPrdt(ConnectionProduct connectPrdt) {
        if (connectPrdt.getCntrPrdtCodes() != null) {
            for (int i = 0; i < connectPrdt.getCntrPrdtCodes().length; i++) {
                connectPrdt.setCntrPrdtCode(connectPrdt.getCntrPrdtCodes()[i]);
                productDao.insertConnectPrdt(connectPrdt);
            }
        }
    }

    // option master
    private void insertPrdtOptionMaster(ProductOptionMaster prdtOptionMaster, ProductOptionDetail prdtOptionDetail) {
        for (int i = 0; i < prdtOptionMaster.getOptnMstrOrders().length; i++) {
            prdtOptionMaster.setOptnMstrOrder(prdtOptionMaster.getOptnMstrOrders()[i]);
            prdtOptionMaster.setOptnMstrName(prdtOptionMaster.getOptnMstrNames()[i]);
            prdtOptionMaster.setOptnMstrId(prdtOptionMaster.getOptnMstrIds()[i]);
            productDao.insertPrdtOptionMaster(prdtOptionMaster);
            insertPrdtOptionDetail(prdtOptionMaster, prdtOptionDetail);
        }
    }

    // option detail
    private void insertPrdtOptionDetail(ProductOptionMaster prdtOptionMaster, ProductOptionDetail prdtOptionDetail) {
        for (int i = 0; i < prdtOptionDetail.getOptnDetailMstrOrders().length; i++) {
            if (StringUtils.equals(prdtOptionMaster.getOptnMstrId(), prdtOptionDetail.getOptnDetailMstrOrders()[i])) {
                prdtOptionDetail.setOptnMstrId(prdtOptionDetail.getOptnDetailMstrOrders()[i]);
                prdtOptionDetail.setOptnId(prdtOptionDetail.getOptnDetailIds()[i]);
                prdtOptionDetail.setOptnValue(prdtOptionDetail.getOptnDetailValues()[i]);
                prdtOptionDetail.setOptnOrder((i + 1) + "");
                prdtOptionDetail.setOptnAmt(prdtOptionDetail.getOptnDetailAmts()[i]);
                productDao.insertPrdtOptionDetail(prdtOptionDetail);
            }
        }
    }

    // option stock
    private void insertPrdtOptionStock(ProductOptionStock prdtOptionStock, ProductOptionSelect prdtOptionSelect) {
        prdtOptionStock.setSellCount("0");
        prdtOptionStock.setDelYn("N");
        for (int i = 0; i < prdtOptionSelect.getStockIndex().length; i++) {
            if (Arrays.stream(prdtOptionSelect.getSelectStockIndex()).anyMatch((i + "")::equals)) {
                prdtOptionStock.setStockSeq((i + 1) + "");
                prdtOptionStock.setStockCount(prdtOptionSelect.getSelectedStockCounts()[i]);
                if (prdtOptionSelect.getSelectedOptnDispYns()[i].equals("true")) {
                    prdtOptionStock.setDispYn("Y");
                } else {
                    prdtOptionStock.setDispYn("N");
                }
                productDao.insertPrdtOptionStock(prdtOptionStock);
                // option select
                if (Arrays.stream(prdtOptionSelect.getSelectStockIndex()).anyMatch((i + "")::equals)) {
                    String[] selectOptionDtlId = prdtOptionSelect.getSelectedOptnDtlIds()[i].split("-");
                    for (int j = 0; j < selectOptionDtlId.length; j++) {
                        prdtOptionSelect.setOptnMstrId(selectOptionDtlId[j].split(":")[0].substring(2));
                        prdtOptionSelect.setOptnId(selectOptionDtlId[j].split(":")[1]);
                        prdtOptionSelect.setStockSeq((i + 1) + "");
                        productDao.insertPrdtOptionSelect(prdtOptionSelect);
                    }
                }
            }
        }
    }

    // image resize
    private void resize(MultipartFile file, int width, int height, String savePath, String secondName, String ext)
            throws IOException {
        BufferedImage inputImage = ImageIO.read(file.getInputStream());

        Image resizeImage = inputImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = newImage.getGraphics();
        g.drawImage(resizeImage, 0, 0, null);
        g.dispose();

        ImageIO.write(newImage, ext, new File(savePath + "/" + secondName));

    }
}
