package com.nuxeo.studio;

public class StudioConstant {
    public static final String BUNDLE_NAME = "studio.extensions.tcasanova-SANDBOX";

    public static final String DOMAIN_DOC_TYPE = "Domain";

    public static final String FILE_DOC_TYPE = "File";

    public static final String PRODUCT_DOC_TYPE = "Product";

    public static final String VISUAL_DOC_TYPE = "Visual";

    public static final String PRODUCT_SCHEMA = "product";

    public static final String PRODUCT_SCHEMA_DELIVERY_TIME_PROPERTY = "product:delivery_time";

    public static final String PRODUCT_SCHEMA_DISTRIBUTOR_PROPERTY = "product:distributor";

   // public static final String PRODUCT_SCHEMA = "product_schema";

    public static final String PRODUCT_SCHEMA_AVAILABLE_IMMEDIATLY_PROPERTY = "product_sch:available_immediatly";

    public static final String PRODUCT_SCHEMA_CATEGORY_PROPERTY = "product_sch:category";

    public static final String PRODUCT_SCHEMA_NAME_PROPERTY = "product_sch:name";

    public static final String PRODUCT_SCHEMA_ORIGIN_OF_FABRICATION_PROPERTY = "product_sch:origin_of_fabrication";

    public static final String PRODUCT_SCHEMA_PRICE_PROPERTY = "product_sch:price";

    public static final String PRODUCT_SCHEMA_SIZE_PROPERTY = "product_sch:size";

    public static final String SYSTEM_SCHEMA = "system";

    public static final String SYSTEM_SCHEMA_FULLTEXT_PROPERTY = "ecm:fulltext";

    public static final String SYSTEM_SCHEMA_PATH_PROPERTY = "ecm:path";

    public static final String SYSTEM_SCHEMA_NAME_PROPERTY = "ecm:name";

    public static final String SYSTEM_SCHEMA_PRIMARY_TYPE_PROPERTY = "ecm:primaryType";

    public static final String SYSTEM_SCHEMA_MIXIN_TYPE_PROPERTY = "ecm:mixinType";

    public static final String SYSTEM_SCHEMA_CURRENT_LIFE_CYCLE_STATE_PROPERTY = "ecm:currentLifeCycleState";

    public static final String SYSTEM_SCHEMA_VERSION_LABEL_PROPERTY = "ecm:versionLabel";

    public static final String SYSTEM_SCHEMA_UUID_PROPERTY = "ecm:uuid";

    public static final String SYSTEM_SCHEMA_PARENT_ID_PROPERTY = "ecm:parentId";

    public static final String SYSTEM_SCHEMA_ANCESTOR_ID_PROPERTY = "ecm:ancestorId";

    public static final String SYSTEM_SCHEMA_REPOSITORY_NAME_PROPERTY = "ecm:repositoryName";

    public static final String SYSTEM_SCHEMA_IS_VERSION_PROPERTY = "ecm:isVersion";

    public static final String SYSTEM_SCHEMA_IS_TRASHED_PROPERTY = "ecm:isTrashed";

    public static final String SYSTEM_SCHEMA_IS_PROXY_PROPERTY = "ecm:isProxy";

    public static final String SYSTEM_SCHEMA_LOCK_OWNER_PROPERTY = "ecm:lockOwner";

    public static final String SYSTEM_SCHEMA_LOCK_CREATED_PROPERTY = "ecm:lockCreated";

    public static final String SYSTEM_SCHEMA_TAG_PROPERTY = "ecm:tag";

    public static final String VALIDATION_SCHEMA = "validation";

    public static final String VALIDATION_SCHEMA_STATUS_PROPERTY = "validation:status";

    public static final String VALIDATION_SCHEMA_VALIDATION_DATE_PROPERTY = "validation:validation_date";

    public static final String VALIDATION_SCHEMA_VALIDATOR_PROPERTY = "validation:validator";

    public static final String DEFAULT_LIFECYCLE = "default";

    public static final String DEFAULT_LIFECYCLE_APPROVE_TRANSITION = "approve";

    public static final String DEFAULT_LIFECYCLE_BACK_TO_PROJECT_TRANSITION = "backToProject";

    public static final String DEFAULT_LIFECYCLE_DELETE_TRANSITION = "delete";

    public static final String DEFAULT_LIFECYCLE_OBSOLETE_TRANSITION = "obsolete";

    public static final String DEFAULT_LIFECYCLE_UNDELETE_TRANSITION = "undelete";

    public static final String DEFAULT_LIFECYCLE_APPROVED_STATE = "approved";

    public static final String DEFAULT_LIFECYCLE_DELETED_STATE = "deleted";

    public static final String DEFAULT_LIFECYCLE_OBSOLETE_STATE = "obsolete";

    public static final String DEFAULT_LIFECYCLE_PROJECT_STATE = "project";

    public static final String VISUAL_LYFE_CYCLE_LIFECYCLE = "visualLyfeCycle";

    public static final String VISUAL_LYFE_CYCLE_LIFECYCLE_AUTO_SET_TO_PENDING_TRANSITION = "autoSetToPending";

    public static final String VISUAL_LYFE_CYCLE_LIFECYCLE_REJECTION_TRANSITION = "rejection";

    public static final String VISUAL_LYFE_CYCLE_LIFECYCLE_UPDATED_TRANSITION = "updated";

    public static final String VISUAL_LYFE_CYCLE_LIFECYCLE_VALIDATION_SUCCES_TRANSITION = "validation_succes";

    public static final String VISUAL_LYFE_CYCLE_LIFECYCLE_TRASH_STATE = "Trash";

    public static final String VISUAL_LYFE_CYCLE_LIFECYCLE_VISUAL_IMPORTED_STATE = "Visual_Imported";

    public static final String VISUAL_LYFE_CYCLE_LIFECYCLE_PENDING_APPOVAL_STATE = "pending_appoval";

    public static final String VISUAL_LYFE_CYCLE_LIFECYCLE_REJECTED_STATE = "rejected";

    public static final String VISUAL_LYFE_CYCLE_LIFECYCLE_VALIDATED_STATE = "validated";

    public static final String AUTO_SET_VISUAL_PENDING_STATUS_CHAIN = "autoSetVisualPendingStatus";

    public static final String AUTO_SET_VISUAL_VALIDATED_CHAIN = "autoSetVisualValidated";

    public static final String AUTOSET_VISUAL_REJECTED_CHAIN = "autosetVisualRejected";

    public static final String CHAIN_UPDATE_PRICE_CHAIN = "chainUPdatePrice";

    public static final String EXPORT_TO_FS_CHAIN = "exportToFS";

    public static final String UPDATE_VISUAL_META_DATA_CHAIN = "updateVisualMetaData";

    public static final String GET_BOUNDING_COLLECTION_SCRIPT = "javascript.getBoundingCollection";

    /**
     * Fixed Part: "ecm:mixinType != 'HiddenInNavigation' AND ecm:isVersion = 0 AND ecm:isTrashed = 0 AND ecm:primaryType = 'Visual'"
     */
    public static final String VISUAL_PAGE_PROVIDER = "visualPageProvider";

}
