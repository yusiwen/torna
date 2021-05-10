import { BaseTranslator } from '../base'

// Mapping
const MAPPING = {
  'ok': 'OK',
  'cancel': 'Cancel',
  'home': 'Home',
  'adminManage': 'Backend Management',
  'previewModel': 'Preview Model',
  'helpCenter': 'Help Center',
  'userMsgReadAll': 'Set all read',
  'userMsgCenter': 'Message Center',
  'userMsgNoMsg': 'No Message',
  'viewDoc': 'View Doc',
  'setRead': 'Set read',
  'userCenter': 'User Center',
  'logout': 'Logout',
  'spaceList': 'Spaces',
  'createSpace': 'New Space',
  'creator': 'Creator',
  'createTime': 'Create Time',
  'spaceName': 'Space Name',
  'spaceAdmin': 'Space Admin',
  'dlgCancel': 'Cancel',
  'dlgSave': 'Save',
  'notEmpty': 'Can not empty',
  'createSuccess': 'Create Success',
  'filterWithUsername': 'Filter with username',
  'selectUser': 'Please select user',
  'projectList': 'Projects',
  'spaceInfo': 'Space Info',
  'spaceMember': 'Members',
  'openUser': 'Open User',
  'apiDoc': 'API Doc',
  'projectInfo': 'Project Info',
  'projectMember': 'Project Member',
  'createProject': 'New Project',
  'noProject': 'No project',
  'privateProject': 'Private Project',
  'projectDesc': 'Description',
  'projectName': 'Project Name',
  'visitPermission': 'Visit Permission',
  'private': 'Private',
  'privateDesc': 'Private：Only project members can visit',
  'public': 'Public',
  'publicDesc': 'Public：All Space users can visit',
  'addSuccess': 'Create Success',
  'deleteSpace': 'Delete Space',
  'deleteSpaceConfirm': 'Delete this space?',
  'deleteSuccess': 'Delete Success',
  'tip': 'Tip',
  'loginAccount': 'Login Account',
  'search': 'Search',
  'addMember': 'Add Member',
  'member': 'Member',
  'me': 'Me',
  'role': 'Role',
  'joinTime': 'Join Time',
  'operation': 'Operation',
  'removeConfirm': 'Remove {0} ？',
  'remove': 'Remove',
  'addUser': 'Add User',
  'user': 'User',
  'pleaseSelect': 'Please select',
  'removeSuccess': 'Remove success',
  'updateSuccess': 'Update success',
  'visitor': 'Guest',
  'developer': 'Developer',
  'createAccount': 'New Account',
  'applicant': 'Applicant',
  'status': 'Status',
  'enable': 'Enable',
  'disable': 'Disable',
  'addTime': 'Add Time',
  'enableAccountConfirm': 'Enable this account？',
  'disableAccountConfirm': 'Disable this account？',
  'resetSecretConfirm': 'Reset secret？',
  'resetSecret': 'Reset Secret',
  'operateSuccess': 'Operate success',
  'notEmptyLengthLimit': 'Can not empty and max-length is {0}',
  'apiList': 'API List',
  'dictionaryManagement': 'Dictionary Management',
  'moduleSetting': 'Module Setting',
  'shareManagement': 'Share Management',
  'createFolder': 'New Folder',
  'apiFilter': 'Filter with ID/Name/URL',
  'refreshTable': 'Refresh Table',
  'export': 'Export',
  'docName': 'Name',
  'hidden': 'Hidden',
  'modifierName': 'Modifier',
  'updateTime': 'Update Time',
  'createDoc': 'New Doc',
  'preview': 'Preview',
  'update': 'Update',
  'more': 'More',
  'copy': 'Copy',
  'delete': 'Delete',
  'refreshSuccess': 'Refresh success',
  'inputFolderMsg': 'Folder name',
  'updateFolderTitle': 'Update Folder',
  'newFolderTitle': 'New Folder',
  'deleteConfirm': 'Delete {0} ？',
  'exportDoc': 'Export Doc',
  'exportAs': 'Export As',
  'singlePage': 'Single Page',
  'multiPage': 'Multi Pages',
  'fileType': 'File Type',
  'selectDoc': 'Choose Doc',
  'allDocs': 'All Docs',
  'partDocs': 'Parts Docs',
  'dlgExport': 'Export',
  'pleaseCheckDoc': 'Please choose doc',
  'filterNameUrl': 'Filter with name/url',
  'appendShare': 'Append Share',
  'appendShareTip': 'Checked: New docs under this folder can be visited',
  'newDictCategory': 'New Dictionary Category',
  'newDict': 'New Dictionary',
  'name': 'Name',
  'type': 'Type',
  'value': 'Value',
  'description': 'Description',
  'categoryName': 'Category Name',
  'lengthLimit': 'Max length is {0}',
  'updateDictCategory': 'Update Dictionary Category',
  'updateDict': 'Update Dictionary',
  'moduleList': 'Module List',
  'newModule': 'New Module',
  'importSwaggerDoc': 'Import Swagger',
  'importPostmanDoc': 'Import Postman',
  'syncSwaggerDoc': 'Sync Swagger',
  'inputModuleName': 'Input Module Name',
  'syncSuccess': 'Sync success',
  'importSwaggerPlaceholder': 'url, such as: http://xxx:8080/swagger/doc.json',
  'basicAuth': 'Basic Auth',
  'optionalUsername': 'Optional，username',
  'optionalPassword': 'Optional，password',
  'dlgImport': 'Import',
  'errorUrl': 'Error Url',
  'importSuccess': 'Import success',
  'chooseFile': 'Choose File',
  'importPostmanTip': 'Choose Postman export file(Collection v2.1)',
  'pleaseUploadFile': 'Please update file',
  'onlyChooseOneFile': 'Only one file',
  'deleteModule': 'Delete Module',
  'commonHeader': 'Common Headers',
  'commonRequest': 'Common Request',
  'commonResponse': 'Common Response',
  'debugEnv': 'Debug Environment',
  'swaggerSetting': 'Swagger Setting',
  'deleteModuleConfirm': 'Delete this Module?',
  'add': 'New',
  'errorParam': 'Error Content, support letter/numer/-/_',
  'newHeader': 'New Header',
  'updateHeader': 'Update Header',
  'paramName': 'Param Name',
  'example': 'Example',
  'addChildNode': 'Add Child Node',
  'isDataNode': 'Data Node',
  'addParam': 'New Param',
  'updateParam': 'Update Param',
  'addChildTitle': 'New Param - Child of {0}',
  'linkDict': 'Link Dict',
  'helpBook': 'Help Book',
  'addEnv': 'New Environment',
  'updateEnv': 'Update Environment',
  'envName': 'Environment Name',
  'baseUrl': 'Base Url',
  'envNamePlaceholder': 'Such as: Test Env',
  'baseUrlPlaceholder': 'Such as: http://10.0.1.31:8080',
  'swaggerMultiMethod': 'Multi methods show',
  'whatsOpenApi': 'What\'s OpenAPI',
  'whatsOpenApiText': 'Request API to operate documents, third-party application can update documents by this way.',
  'useStep': 'Use steps',
  'useStep1': '1、Find space admin to get AppKey and Secret',
  'useStep2': '2、Project depend SDK，request API with SDK',
  'requestUrl': 'Url',
  'spaceAdminSupply': 'Space admin supplied',
  'refreshTokenConfirm': 'Refresh token? Old token will not available',
  'refreshToken': 'Refresh Token',
  'openApiLink': 'OpenAPI Doc',
  'newShare': 'New Share',
  'shareUrl': 'Share Url',
  'shareDoc': 'Share Doc',
  'shareStyle': 'Share Style',
  'encryption': 'Encryption',
  'deleteRowConfirm': 'Delete record?',
  'remark': 'Remark',
  'optional': 'optional',
  'wholeModule': '(whole module)',
  'updateShare': 'Update Share',
  'look': 'See',
  'pwdShow': 'Password: ',
  'remarkShow': '[Remark]: ',
  'projectAdmin': 'Project Admin',
  'updateProject': 'Update Project',
  'deleteProject': 'Delete Project',
  'deleteProjectConfirm': 'Delete project?',
  'accountInfo': 'Account Info',
  'baseInfo': 'Base Info',
  'updatePassword': 'Update Password',
  'baseSetting': 'Base Setting',
  'subscription': 'Subscription',
  'subscribeApi': 'Subscribe API',
  'messageCenter': 'Message Center',
  'myMessage': 'My Messages',
  'nickname': 'Nickname',
  'email': 'Email',
  'regTime': 'Sign in time',
  'saveSuccess': 'Save success',
  'oldPassword': 'Old Password',
  'newPassword': 'New Password',
  'newPasswordConfirm': 'Confirm Password',
  'dlgUpdate': 'Update',
  'notSamePassword': 'Password not same',
  'updatePasswordSuccess': 'Update success，go login',
  'mySubscribeApi': 'My Subscription',
  'apiName': 'API Name',
  'cancelSubscribeConfirm': 'Unsubscribe {0} ？',
  'cancelSubscribe': 'Unsubscribe',
  'content': 'Content',
  'unread': 'Unread',
  'read': 'Read',
  'pushTime': 'Push Time',
  'addNewUser': 'New User',
  'superAdmin': 'Super Admin',
  'origin': 'Origin',
  'normal': 'OK',
  'inactive': 'Inactive',
  'resetPasswordConfirm': 'Reset {0} password？',
  'resetPassword': 'Reset Password',
  'disableConfirm': 'Disable {0} ?',
  'enableConfirm': 'Enable {0} ?',
  'suggestUseEmail': 'suggest email',
  'suggestUseRealName': '',
  'isSuperAdmin': 'Is super admin',
  'selfReg': 'Self sign in',
  'thirdPartyLogin': 'Third-party login',
  'backendAdd': 'Backend create',
  'unknown': 'Unknown',
  'resetPasswordSuccess': 'New Password：{0}',
  'resetSuccess': 'Reset success',
  'addUserSuccess': 'Login Account:{0}\nPassword:{1}',
  'docManagement': 'Doc Management',
  'userManagement': 'User Management',
  'docTitle': 'Title',
  'docDesc': 'Description',
  'pathVariable': 'PathVariable',
  'sourceFolder': 'Folder',
  'empty': 'Empty',
  'isShow': 'Show',
  'requestHeader': 'Request Header',
  'importHeader': 'Import Header',
  'useCommonHeader': 'Use Common Header',
  'requestParams': 'Request',
  'newQueryParam': 'New Query Parameter',
  'importQueryParam': 'Import Query Parameter',
  'newBodyParam': 'New Body Parameter',
  'importBodyParam': 'Import Body Parameter',
  'useCommonParam': 'Use Common Parameter',
  'responseParam': 'Response',
  'newResponseParam': 'New Response Parameter',
  'importResponseParam': 'Import Response Parameter',
  'useCommonResponse': 'Use Common Response',
  'errorCode': 'Error Code',
  'newErrorCode': 'New Error Code',
  'errorDesc': 'Error Description',
  'solution': 'Solution',
  'currentUpdateRemark': 'Update remark',
  'back': 'Back',
  'save': 'Save',
  'importJson': 'Import Json',
  'importByQueryParam': 'Query Parameter',
  'importByBulk': 'Bulk Mode（Postman Bulk Edit）',
  'importResponseParamTip': 'Enter the complete response results to fill in the test data. [Pay attention to sensitive information, do not import online data]',
  'pleaseInputJson': 'Enter json',
  'jsonType': 'Json Type',
  'require': 'Require',
  'maxLength': 'Max Length',
  'clickRestore': 'Restore',
  'emptyData': 'Empty data',
}

export class Translator extends BaseTranslator {
  getMapping() {
    return MAPPING
  }
}

