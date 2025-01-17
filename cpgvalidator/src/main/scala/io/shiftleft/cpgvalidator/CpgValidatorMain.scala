package io.shiftleft.cpgvalidator

import io.shiftleft.codepropertygraph.cpgloading.{CpgLoader, CpgLoaderConfig, OverflowDbConfig}

object CpgValidatorMain extends App {
  val cpgFileName = args(0)

  val loaderConfig = CpgLoaderConfig().withOverflowConfig(OverflowDbConfig.disabled)
  val cpg = CpgLoader.load(cpgFileName, loaderConfig)

  val validator = new CpgValidator(cpg)
  val cpgValid = validator.validate()
  validator.logValidationErrors()

  if (cpgValid) {
    System.exit(0)
  } else {
    System.exit(1)
  }
}
