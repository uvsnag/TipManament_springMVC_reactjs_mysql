package com.tip.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tip.common.Common;
import com.tip.dao.MasterCategoryDAO;
import com.tip.dao.SubCategoryDAO;
import com.tip.dao.TipDAO;
import com.tip.form.CategoryForm;
import com.tip.form.TipForm;
import com.tip.form.TipInfo3Level;
import com.tip.model.CategoryMaster;
import com.tip.model.SubCategory;
import com.tip.model.Tip;

@CrossOrigin("*")
@RestController
public class TipsController {

	@Autowired
	private TipDAO tipDAO;
	@Autowired
	private MasterCategoryDAO masterCategotyDAO;
	@Autowired
	private SubCategoryDAO subCategoryDAO;

	@RequestMapping(value = { "/all-tips" }, method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<TipInfo3Level> getAllTips(
			@RequestParam(required = false, name = "dataDeleted", defaultValue = "false") boolean dataDeleted) {
		List<TipInfo3Level> result = new ArrayList<>();
		List<CategoryMaster> categoryMasterList = dataDeleted ? masterCategotyDAO.findAllIncludingDeleted()
				: masterCategotyDAO.findAll();
		TipInfo3Level tipInfo3Level = null;
		for (CategoryMaster categoryMaster : categoryMasterList) {
			tipInfo3Level = new TipInfo3Level();
			tipInfo3Level.setCategoryMaster(categoryMaster);
			List<SubCategory> SubCategoryList = dataDeleted
					? subCategoryDAO.findByIdMasterIncludingDeleted(categoryMaster.getId())
					: subCategoryDAO.findByIdMaster(categoryMaster.getId());

			for (SubCategory subCategory : SubCategoryList) {
				List<Tip> tips = dataDeleted ? tipDAO.findByIdTypeIncludingDeleted(subCategory.getId())
						: tipDAO.findByIdType(subCategory.getId());
				subCategory.setTips(tips);
			}
			tipInfo3Level.setSubCategory(SubCategoryList);
			result.add(tipInfo3Level);
		}
		return result;
	}

	@RequestMapping(value = { "/view-tip" }, method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Tip getTipDetail(@RequestParam(required = true, name = "id") Integer id) {

		Tip tip = tipDAO.findByIdIncludingDeleted(id);
		return tip;
	}

	@RequestMapping(value = { "/find-tip" }, method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Tip> findbyContens(@RequestParam(required = true, name = "strSearch") String strSearch) {

		List<Tip> tips = tipDAO.findbyContens(strSearch);
		return tips;
	}
	@RequestMapping(value = { "/get-sub" }, method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<SubCategory> getSub() {
		
		List<SubCategory> subCategorys = subCategoryDAO.findAll();
		return subCategorys;
	}

	@RequestMapping(value = { "/view-sub" }, method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public SubCategory getSubDetail(@RequestParam(required = true, name = "id") Integer id) {
		SubCategory result = subCategoryDAO.findByIdIncludingDeleted(id);
		return result;
	}

	@RequestMapping(value = { "/view-master" }, method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public CategoryMaster getMasterDetail(@RequestParam(required = true, name = "id") Integer id) {

		CategoryMaster result = masterCategotyDAO.findByIdIncludingDeleted(id);
		return result;
	}

	@RequestMapping(value = { "/save" }, method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public int save(@RequestBody CategoryForm categoryForm) {
		int result = 404;

		if (Objects.nonNull(categoryForm) && Objects.nonNull(categoryForm.getName())) {

			if (StringUtils.equals(categoryForm.getTypeCategory(), "master")) {
				CategoryMaster categoryMaster = new CategoryMaster();
				categoryMaster.setName(categoryForm.getName());
				categoryMaster.setDescription(categoryForm.getDescription());
				categoryMaster.setUpdateDate(Common.getCurrentDateAsStr());
				if (StringUtils.equals(categoryForm.getTypeUpdate(), "update")) {
					categoryMaster.setId(categoryForm.getId());
					result = masterCategotyDAO.update(categoryMaster);
				} else {
					result = masterCategotyDAO.insert(categoryMaster);
				}
			}
			if (StringUtils.equals(categoryForm.getTypeCategory(), "sub")) {
				SubCategory subCategory = new SubCategory();
				subCategory.setName(categoryForm.getName());
				subCategory.setDescription(categoryForm.getDescription());
				subCategory.setIdMaster(categoryForm.getIdParent());
				subCategory.setUpdateDate(Common.getCurrentDateAsStr());

				if (StringUtils.equals(categoryForm.getTypeUpdate(), "update")) {
					subCategory.setId(categoryForm.getId());
					result = subCategoryDAO.update(subCategory);
				} else {
					result = subCategoryDAO.insert(subCategory);
				}
			}
		}

		return result;
	}

	@RequestMapping(value = { "/save-tip" }, method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public int saveTip(@RequestBody TipForm tipForm) {
		int result = 404;

		if (Objects.nonNull(tipForm) && Objects.nonNull(tipForm.getName())) {
			Tip tip = new Tip();
			tip.setName(tipForm.getName());
			tip.setContents(tipForm.getContents());
			tip.setIdType(tipForm.getIdType());
			tip.setUpdateDate(Common.getCurrentDateAsStr());
			if (StringUtils.equals(tipForm.getTypeUpdate(), "update")) {
				tip.setId(tipForm.getId());
				result = tipDAO.update(tip);
			} else {
				result = tipDAO.insert(tip);
			}

		}
		return result;
	}

	@RequestMapping(value = { "/delete-temp" }, method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public int deleteTemp(@RequestParam(required = true, name = "type") String type,
			@RequestParam(required = true, name = "id") Integer id) {
		int result = 404;

		if (StringUtils.equals(type, "master")) {
			CategoryMaster categoryMaster = masterCategotyDAO.findById(id);
			if (Objects.nonNull(categoryMaster) && categoryMaster.getId() != null) {
				masterCategotyDAO.deleteTemp(id);
			} else {
//				masterCategotyDAO.delete(id);
				isdeleteTempMasterCategory(id);
			}

		} else if (StringUtils.equals(type, "sub")) {
			SubCategory subCategory = subCategoryDAO.findById(id);
			if (Objects.nonNull(subCategory) && subCategory.getId() != null) {
				subCategoryDAO.deleteTemp(id);
			} else {
//				subCategoryDAO.delete(id);
				deleteTempSubCategory(id);
			}
		} else if (StringUtils.equals(type, "tip")) {
			Tip tip = tipDAO.findById(id);
			if (Objects.nonNull(tip) && tip.getId() != null) {
				tipDAO.deleteTemp(id);
			} else {
				tipDAO.delete(id);
			}
		}
		return result;
	}

	private boolean isdeleteTempMasterCategory(Integer id) {
		List<SubCategory> subs = subCategoryDAO.findByIdMaster(id);
		if (CollectionUtils.isEmpty(subs)) {
			masterCategotyDAO.delete(id);
			return true;
		}
		return false;
	}

	private boolean deleteTempSubCategory(Integer id) {
		List<Tip> tips = tipDAO.findByIdType(id);
		if (CollectionUtils.isEmpty(tips)) {
			subCategoryDAO.delete(id);
			return true;
		}
		return false;
	}
	@RequestMapping(value = { "/restore-temp" }, method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public int restoreTemp(@RequestParam(required = true, name = "type") String type,
			@RequestParam(required = true, name = "id") Integer id) {
		int result = 404;
		
		if (StringUtils.equals(type, "master")) {
				masterCategotyDAO.restore(id);
			
		} else if (StringUtils.equals(type, "sub")) {
				subCategoryDAO.restore(id);
		} else if (StringUtils.equals(type, "tip")) {
				tipDAO.restore(id);
		}
		return result;
	}
}