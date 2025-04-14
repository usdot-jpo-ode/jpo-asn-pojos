#!/usr/bin/env bash
#
# This script is to be used during the PR review process to pull in any changes from a "main" branch
# into the branch under review, in the event the clases need to be regenerated.  It pulls in the
# subset of classes in this and previously merged PRs.
#
# Prerequisites:
#   Git Bash shell
#

# echo on
set -x

BRANCH=j2735-2024-part-9
PACKAGE=src/main/java/us/dot/its/jpo/asn/j2735/r2024

echo "Checkout files from $BRANCH"

MODULE=""

function checkout() {
  git checkout $BRANCH ${PACKAGE}/${MODULE}/$1
}

MODULE=AddGrpB
checkout DegreesLat.java
checkout DegreesLong.java
checkout Elevation.java
checkout LaneDataAttribute_addGrpB.java
checkout LaneDataAttribute_addGrpBReg_LaneDataAttribute.java
checkout LatitudeDMS.java
checkout LatitudeDMS2.java
checkout LongitudeDMS.java
checkout LongitudeDMS2.java
checkout MaxTimetoChange.java
checkout MinTimetoChange.java
checkout MinutesAngle.java
checkout MovementEvent_addGrpB.java
checkout MovementEvent_addGrpBReg_MovementEvent.java
checkout NodeOffsetPointXY_addGrpB.java
checkout NodeOffsetPointXY_addGrpBReg_NodeOffsetPointXY.java
checkout Node_LLdms_48b.java
checkout Node_LLdms_80b.java
checkout Position3D_addGrpB.java
checkout Position3D_addGrpBReg_Position3D.java
checkout SecondsAngle.java
checkout TimeRemaining.java

MODULE=AddGrpC
checkout Altitude.java
checkout AltitudeConfidence.java
checkout AltitudeValue.java
checkout ConnectionManeuverAssist_addGrpC.java
checkout ConnectionManeuverAssist_addGrpCReg_ConnectionManeuverAssist.java
checkout EmissionType.java
checkout IntersectionState_addGrpC.java
checkout IntersectionState_addGrpCReg_IntersectionState.java
checkout MapData_addGrpC.java
checkout MapData_addGrpCReg_MapData.java
checkout Position3D_addGrpC.java
checkout Position3D_addGrpCReg_Position3D.java
checkout PrioritizationResponse.java
checkout PrioritizationResponseList.java
checkout RestrictionUserType_addGrpC.java
checkout RestrictionUserType_addGrpCReg_RestrictionUserType.java
checkout SignalHeadLocation.java
checkout SignalHeadLocationList.java
checkout VehicleToLanePosition.java
checkout VehicleToLanePositionList.java

MODULE=BasicSafetyMessage
checkout BSMpartIIExtension.java
checkout BasicSafetyMessage.java
checkout DisabledVehicle.java
checkout EventDescription.java
checkout IsDolly.java
checkout ObstacleDetection.java
checkout ObstacleDirection.java
checkout PartII_Id.java
checkout PartIIcontent.java
checkout PivotPointDescription.java
checkout PivotingAllowed.java
checkout RTCMPackage.java
checkout SpecialVehicleExtensions.java
checkout SpecialVehicleExtensionsBSMpartIIExtension.java
checkout SpeedProfile.java
checkout SpeedProfileMeasurement.java
checkout SpeedProfileMeasurementList.java
checkout SupplementalVehicleExtensions.java
checkout SupplementalVehicleExtensionsBSMpartIIExtension.java
checkout TrailerData.java
checkout TrailerHistoryPoint.java
checkout TrailerHistoryPointList.java
checkout TrailerMass.java
checkout TrailerUnitDescription.java
checkout TrailerUnitDescriptionList.java
checkout VehicleData.java
checkout VertOffset_B07.java
checkout WeatherProbe.java
checkout WeatherReport.java

MODULE=Common
checkout Acceleration.java
checkout AccelerationSet4Way.java
checkout AmbientAirPressure.java
checkout AmbientAirTemperature.java
checkout Angle.java
checkout AntennaOffsetSet.java
checkout AntiLockBrakeStatus.java
checkout ApproachID.java
checkout AsphaltOrTar.java
checkout AsphaltOrTarType.java
checkout AuxiliaryBrakeStatus.java
checkout Axles.java
checkout BSMcoreData.java
checkout BasicVehicleClass.java
checkout BasicVehicleRole.java
checkout BrakeAppliedStatus.java
checkout BrakeBoostApplied.java
checkout BrakeSystemStatus.java
checkout BumperHeight.java
checkout BumperHeights.java
checkout Cinders.java
checkout CindersType.java
checkout CoarseHeading.java
checkout CoefficientOfFriction.java
checkout ComputedLane.java
checkout Confidence.java
checkout DDate.java
checkout DDateTime.java
checkout DDay.java
checkout DHour.java
checkout DMinute.java
checkout DMonth.java
checkout DOffset.java
checkout DSecond.java
checkout DTime.java
checkout DYear.java
checkout DeltaAngle.java
checkout DescriptionOfRoadSurface.java
checkout DescriptiveName.java
checkout DrivenLineOffsetLg.java
checkout DrivenLineOffsetSm.java
checkout Elevation.java
checkout ElevationConfidence.java
checkout EmergencyDetails.java
checkout Extent.java
checkout ExteriorLights.java
checkout FrictionInformation.java
checkout FuelType.java
checkout FullPositionVector.java
checkout FullRoadAuthorityID.java
checkout FurtherInfoID.java
checkout GNSSstatus.java
checkout Grass.java
checkout GrassType.java
checkout Gravel.java
checkout GravelType.java
checkout GrossSpeed.java
checkout Heading.java
checkout HeadingConfidence.java
checkout HeadingSlice.java
checkout Ice.java
checkout IceType.java
checkout IntersectionAccessPoint.java
checkout IntersectionID.java
checkout IntersectionReferenceID.java
checkout Iso3833VehicleType.java
checkout LaneConnectionID.java
checkout LaneDataAttribute.java
checkout LaneDataAttributeList.java
checkout LaneID.java
checkout LaneWidth.java
checkout Latitude.java
checkout LightbarInUse.java
checkout Longitude.java
checkout MeanVariation.java
checkout MergeDivergeNodeAngle.java
checkout MinuteOfTheYear.java
checkout MsgCount.java
checkout MultiVehicleResponse.java
checkout NodeAttributeSetXY.java
checkout NodeAttributeXY.java
checkout NodeAttributeXYList.java
checkout NodeListXY.java
checkout NodeOffsetPointXY.java
checkout NodeSetXY.java
checkout NodeXY.java
checkout Node_LLmD_64b.java
checkout Node_XY_20b.java
checkout Node_XY_22b.java
checkout Node_XY_24b.java
checkout Node_XY_26b.java
checkout Node_XY_28b.java
checkout Node_XY_32b.java
checkout ObstacleDistance.java
checkout OffsetLL_B18.java
checkout Offset_B09.java
checkout Offset_B10.java
checkout Offset_B11.java
checkout Offset_B12.java
checkout Offset_B13.java
checkout Offset_B14.java
checkout Offset_B16.java
checkout PathHistory.java
checkout PathHistoryPoint.java
checkout PathHistoryPointList.java
checkout PathPrediction.java
checkout PortlandCement.java
checkout PortlandCementType.java
checkout Position3D.java
checkout PositionConfidence.java
checkout PositionConfidenceSet.java
checkout PositionalAccuracy.java
checkout PrioritizationResponseStatus.java
checkout Priority.java
checkout PrivilegedEventFlags.java
checkout PrivilegedEvents.java
checkout RTCMheader.java
checkout RTCMmessage.java
checkout RTCMmessageList.java
checkout RadiusOfCurvature.java
checkout RegionId.java
checkout RegionalExtension.java
checkout RegulatorySpeedLimit.java
checkout RelativeRoadAuthorityID.java
checkout RequestID.java
checkout RequestImportanceLevel.java
checkout RequestSubRole.java
checkout RequestorType.java
checkout ResponseType.java
checkout RestrictionClassID.java
checkout RoadAuthorityID.java
checkout RoadRegulatorID.java
checkout RoadRoughness.java
checkout RoadSegmentID.java
checkout RoadSegmentReferenceID.java
checkout RoadSurfaceCondition.java
checkout RoadwayCrownAngle.java
checkout Rock.java
checkout RockType.java
checkout SSPindex.java
checkout Scale_B12.java
checkout SchoolBusJ2945Slash1C.java
checkout SegmentAttributeXY.java
checkout SegmentAttributeXYList.java
checkout SemiMajorAxisAccuracy.java
checkout SemiMajorAxisOrientation.java
checkout SemiMinorAxisAccuracy.java
checkout SignalGroupID.java
checkout SirenInUse.java
checkout Snow.java
checkout SnowType.java
checkout Speed.java
checkout SpeedConfidence.java
checkout SpeedLimitList.java
checkout SpeedLimitType.java
checkout SpeedandHeadingandThrottleConfidence.java
checkout StabilityControlStatus.java
checkout StationID.java
checkout SteeringWheelAngle.java
checkout TemporaryID.java
checkout ThrottleConfidence.java
checkout TimeConfidence.java
checkout TimeOffset.java
checkout TractionControlStatus.java
checkout TrailerUnitDescJ2945Slash1B.java
checkout TrailerWeight.java
checkout TrailersJ2945Slash1B.java
checkout TransmissionAndSpeed.java
checkout TransmissionState.java
checkout VariationStdDev.java
checkout VehicleClassification.java
checkout VehicleEventFlags.java
checkout VehicleHeight.java
checkout VehicleID.java
checkout VehicleLength.java
checkout VehicleMass.java
checkout VehicleSafetyExtensions.java
checkout VehicleSafetyExtensionsBSMpartIIExtension.java
checkout VehicleSafetyExtensionsCCMpartIIExtension.java
checkout VehicleSize.java
checkout VehicleType.java
checkout VehicleWidth.java
checkout Velocity.java
checkout VertOffset_B12.java
checkout VerticalAcceleration.java
checkout VerticalAccelerationThreshold.java
checkout WiperRate.java
checkout WiperSet.java
checkout WiperStatus.java
checkout YawRate.java

MODULE=CommonSafetyRequest
checkout CommonSafetyRequest.java
checkout RequestedItem.java
checkout RequestedItemList.java

MODULE=CooperativeControlMessage
checkout AccelTimeConstant.java
checkout AcceleratorPedalPosition.java
checkout AxesMovement.java
checkout BrakePedalPosition.java
checkout CCMFaultMode.java
checkout CCMPartIIcontent.java
checkout CCMpartIIExtension.java
checkout CooperativeControlMessage.java
checkout FrontCutIn.java
checkout HeavyTruckCCMExtensions.java
checkout HeavyTruckCCMExtensionsCCMpartIIExtension.java
checkout LightVehicleCCMExtensions.java
checkout LightVehicleCCMExtensionsCCMpartIIExtension.java
checkout LongitudinalControlState.java
checkout ManeuverID.java
checkout MaxAvailableAcceleration.java
checkout MaxAvailableDeceleration.java
checkout PartII_Id.java
checkout Pitch.java
checkout PitchRate.java
checkout RoadGrade.java
checkout Roll.java
checkout RollRate.java
checkout SeparationDistance.java
checkout TimeConstant.java
checkout Torque.java
checkout TotalMass.java
checkout Yaw.java

MODULE=EmergencyVehicleAlert
checkout EmergencyVehicleAlert.java

MODULE=ITIS
checkout GenericLocations.java
checkout ITIScodes.java
checkout ITIScodesAndText.java
checkout ITIScodesAndTextSequence.java
checkout ITIStext.java
checkout IncidentResponseEquipment.java
checkout ResponderGroupAffected.java
checkout VehicleGroupAffected.java

MODULE=IntersectionCollision
checkout ApproachOrLane.java
checkout IntersectionCollision.java

MODULE=J2540ITIS
checkout ITISgroups.java

MODULE=ManeuverSharingAndCoordinatingMessage
checkout TemporaryIDPointer.java

MODULE=MapData
checkout AllowedManeuvers.java
checkout ConnectingLane.java
checkout Connection.java
checkout ConnectsToList.java
checkout DataParameters.java
checkout GenericLane.java
checkout IntersectionGeometry.java
checkout IntersectionGeometryList.java
checkout LaneAttributes.java
checkout LaneAttributes_Barrier.java
checkout LaneAttributes_Bike.java
checkout LaneAttributes_Crosswalk.java
checkout LaneAttributes_Parking.java
checkout LaneAttributes_Sidewalk.java
checkout LaneAttributes_Striping.java
checkout LaneAttributes_TrackedVehicle.java
checkout LaneAttributes_Vehicle.java
checkout LaneDirection.java
checkout LaneList.java
checkout LaneSharing.java
checkout LaneTypeAttributes.java
checkout LayerID.java
checkout LayerType.java
checkout MapData.java
checkout OverlayLaneList.java
checkout PreemptPriorityList.java
checkout RestrictionAppliesTo.java
checkout RestrictionClassAssignment.java
checkout RestrictionClassList.java
checkout RestrictionUserType.java
checkout RestrictionUserTypeList.java
checkout RoadLaneSetList.java
checkout RoadSegment.java
checkout RoadSegmentList.java
checkout SignalControlZone.java

MODULE=NMEAcorrections
checkout NMEA_MsgType.java
checkout NMEA_Payload.java
checkout NMEA_Revision.java
checkout NMEAcorrections.java
checkout ObjectCount.java

MODULE=NTCIP
checkout EssMobileFriction.java
checkout EssPrecipRate.java
checkout EssPrecipSituation.java
checkout EssPrecipYesNo.java
checkout EssSolarRadiation.java

MODULE=PersonalSafetyMessage
checkout AnimalPropelledType.java
checkout AnimalType.java
checkout Attachment.java
checkout AttachmentRadius.java
checkout HumanPropelledType.java
checkout MotorizedPropelledType.java
checkout NumberOfParticipantsInCluster.java
checkout PersonalAssistive.java
checkout PersonalClusterRadius.java
checkout PersonalCrossingInProgress.java
checkout PersonalCrossingRequest.java
checkout PersonalDeviceUsageState.java
checkout PersonalDeviceUserType.java
checkout PersonalSafetyMessage.java
checkout PropelledInformation.java
checkout PublicSafetyAndRoadWorkerActivity.java
checkout PublicSafetyDirectingTrafficSubType.java
checkout PublicSafetyEventResponderWorkerType.java
checkout UserSizeAndBehaviour.java

MODULE=ProbeDataReport
checkout RptVehicleClass.java

MODULE=ProbeVehicleData
checkout AccelSteerYawRateConfidence.java
checkout AccelerationConfidence.java
checkout AxleLocation.java
checkout AxleWeight.java
checkout AxleWeightList.java
checkout AxleWeightSet.java
checkout BrakeAppliedPressure.java
checkout CargoWeight.java
checkout ConfidenceSet.java
checkout DriveAxleLiftAirPressure.java
checkout DriveAxleLocation.java
checkout DriveAxleLubePressure.java
checkout DriveAxleTemperature.java
checkout DrivingWheelAngle.java
checkout J1939data.java
checkout ProbeSegmentNumber.java
checkout ProbeVehicleData.java
checkout RainSensor.java
checkout Snapshot.java
checkout SteeringAxleLubePressure.java
checkout SteeringAxleTemperature.java
checkout SteeringWheelAngleConfidence.java
checkout SteeringWheelAngleRateOfChange.java
checkout SunSensor.java
checkout ThrottlePosition.java
checkout TireData.java
checkout TireDataList.java
checkout TireLeakageRate.java
checkout TireLocation.java
checkout TirePressure.java
checkout TirePressureThresholdDetection.java
checkout TireTemp.java
checkout VINstring.java
checkout VehicleIdent.java
checkout VehicleStatus.java
checkout WheelEndElectFault.java
checkout WheelSensorStatus.java
checkout YawRateConfidence.java

MODULE=REGION
checkout Reg_AdvisorySpeed.java
checkout Reg_BasicSafetyMessage.java
checkout Reg_CommonSafetyRequest.java
checkout Reg_ComputedLane.java
checkout Reg_ConnectionManeuverAssist.java
checkout Reg_EmergencyVehicleAlert.java
checkout Reg_EventDescription.java
checkout Reg_GenericLane.java
checkout Reg_GeographicalPath.java
checkout Reg_GeometricProjection.java
checkout Reg_IntersectionCollision.java
checkout Reg_IntersectionGeometry.java
checkout Reg_IntersectionState.java
checkout Reg_LaneAttributes.java
checkout Reg_LaneDataAttribute.java
checkout Reg_MapData.java
checkout Reg_MovementEvent.java
checkout Reg_MovementState.java
checkout Reg_NMEAcorrections.java
checkout Reg_NodeAttributeSetLL.java
checkout Reg_NodeAttributeSetXY.java
checkout Reg_NodeOffsetPointLL.java
checkout Reg_NodeOffsetPointXY.java
checkout Reg_PersonalSafetyMessage.java
checkout Reg_Position3D.java
checkout Reg_ProbeVehicleData.java
checkout Reg_RTCMcorrections.java
checkout Reg_RequestorDescription.java
checkout Reg_RequestorType.java
checkout Reg_RestrictionUserType.java
checkout Reg_RoadSegment.java
checkout Reg_RoadSideAlert.java
checkout Reg_SPAT.java
checkout Reg_SignalControlZone.java
checkout Reg_SignalRequest.java
checkout Reg_SignalRequestMessage.java
checkout Reg_SignalRequestPackage.java
checkout Reg_SignalStatus.java
checkout Reg_SignalStatusMessage.java
checkout Reg_SignalStatusPackage.java
checkout Reg_SupplementalVehicleExtensions.java
checkout Reg_TravelerInformation.java
checkout Reg_VehicleClassification.java

MODULE=RTCMcorrections
checkout RTCM_Revision.java
checkout RTCMcorrections.java

MODULE=RoadSafetyMessage
checkout Activity.java
checkout ApplicableHeading.java
checkout AreaType.java
checkout AudioLink.java
checkout BankAngle.java
checkout BroadRegion.java
checkout BroadRegionArea.java
checkout CommonContainer.java
checkout ContentContainer.java
checkout CrossLinking.java
checkout CurveContainer.java
checkout DynamicInfoContainer.java
checkout ElevOffset.java
checkout EventIdentifier.java
checkout EventInfo.java
checkout EventRecurrence.java
checkout HeadingDeg.java
checkout IncidentsContainer.java
checkout LaneClosed.java
checkout LaneClosureContainer.java
checkout LaneInfo.java
checkout LatOffset.java
checkout LongOffset.java
checkout NodePointLLE.java
checkout Obstructions.java
checkout Offset3D.java
checkout Path.java
checkout PathList.java
checkout PathPoints.java
checkout RSMLanePosition.java
checkout RSMPolygon.java
checkout Radius.java
checkout ReducedSpeedZoneContainer.java
checkout ReferencePointType.java
checkout RegionInfo.java
checkout RegionUncertainty.java
checkout RoadSafetyMessage.java
checkout ShortString.java
checkout SituationalContainer.java
checkout Tolerance.java
checkout VisualLink.java

MODULE=RoadSideAlert
checkout RoadSideAlert.java

MODULE=RoadWeatherMessage
checkout NTCIPEssVisibility.java

MODULE=SPAT
checkout AdvisorySpeed.java
checkout AdvisorySpeedList.java
checkout AdvisorySpeedType.java
checkout ConnectionManeuverAssist.java
checkout EnabledLaneList.java
checkout IntersectionState.java
checkout IntersectionStateList.java
checkout IntersectionStatusObject.java
checkout ManeuverAssistList.java
checkout MovementEvent.java
checkout MovementEventList.java
checkout MovementList.java
checkout MovementPhaseState.java
checkout MovementState.java
checkout PedestrianBicycleDetect.java
checkout SPAT.java
checkout SpeedAdvice.java
checkout TimeChangeDetails.java
checkout TimeIntervalConfidence.java
checkout TimeMark.java
checkout WaitOnStopline.java
checkout ZoneLength.java

MODULE=SensorDataSharingMessage
checkout AngularVelocity.java
checkout AngularVelocityConfidence.java
checkout Attitude.java
checkout AttitudeConfidence.java
checkout ClassificationConfidence.java
checkout DetectedObjectCommonData.java
checkout DetectedObjectData.java
checkout DetectedObjectList.java
checkout DetectedObjectOptionalData.java
checkout DetectedObstacleData.java
checkout DetectedVRUData.java
checkout DetectedVehicleData.java
checkout EquipmentType.java
checkout MeasurementTimeOffset.java
checkout ObjectDistance.java
checkout ObjectID.java
checkout ObjectType.java
checkout ObstacleSize.java
checkout ObstacleSizeConfidence.java
checkout PitchDetected.java
checkout PitchRate.java
checkout PitchRateConfidence.java
checkout PositionOffsetXYZ.java
checkout RollDetected.java
checkout RollRate.java
checkout RollRateConfidence.java
checkout SensorDataSharingMessage.java
checkout SizeValue.java
checkout SizeValueConfidence.java
checkout VehicleSizeConfidence.java
checkout YawDetected.java

MODULE=SignalRequestMessage
checkout DeltaTime.java
checkout PriorityRequestType.java
checkout RequestorDescription.java
checkout RequestorPositionVector.java
checkout SignalRequest.java
checkout SignalRequestList.java
checkout SignalRequestMessage.java
checkout SignalRequestPackage.java
checkout TransitVehicleOccupancy.java
checkout TransitVehicleStatus.java

MODULE=SignalStatusMessage
checkout SignalRequesterInfo.java
checkout SignalStatus.java
checkout SignalStatusList.java
checkout SignalStatusMessage.java
checkout SignalStatusPackage.java
checkout SignalStatusPackageList.java

MODULE=TravelerInformation
checkout Circle.java
checkout DirectionOfUse.java
checkout DistanceUnits.java
checkout ExitService.java
checkout ExitServiceSequence.java
checkout GenericSignage.java
checkout GenericSignageSequence.java
checkout GeographicalPath.java
checkout GeometricProjection.java
checkout ITIStextPhrase.java
checkout MUTCDCode.java
checkout MinutesDuration.java
checkout MsgCRC.java
checkout NodeAttributeLL.java
checkout NodeAttributeLLList.java
checkout NodeAttributeSetLL.java
checkout NodeLL.java
checkout NodeListLL.java
checkout NodeOffsetPointLL.java
checkout NodeSetLL.java
checkout Node_LL_24B.java
checkout Node_LL_28B.java
checkout Node_LL_32B.java
checkout Node_LL_36B.java
checkout Node_LL_44B.java
checkout Node_LL_48B.java
checkout OffsetLL_B12.java
checkout OffsetLL_B14.java
checkout OffsetLL_B16.java
checkout OffsetLL_B22.java
checkout OffsetLL_B24.java
checkout OffsetSystem.java
checkout Radius_B12.java
checkout RegionList.java
checkout RegionOffsets.java
checkout RegionPointSet.java
checkout RoadSignID.java
checkout SegmentAttributeLL.java
checkout SegmentAttributeLLList.java
checkout ShapePointSet.java
checkout SignPriority.java
checkout SpeedLimit.java
checkout SpeedLimitSequence.java
checkout TravelerDataFrame.java
checkout TravelerDataFrameList.java
checkout TravelerDataFrameNewPartIIIContent.java
checkout TravelerInfoType.java
checkout TravelerInformation.java
checkout URL_Base.java
checkout URL_Short.java
checkout UniqueMSGID.java
checkout ValidRegion.java
checkout WorkZone.java
checkout WorkZoneSequence.java
checkout Zoom.java

