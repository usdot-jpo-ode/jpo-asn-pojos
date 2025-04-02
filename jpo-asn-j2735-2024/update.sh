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

BRANCH=j2735-2024-type-refactor-everything
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

MODULE=Common
checkout Acceleration.java
checkout AccelerationSet4Way.java
checkout Angle.java
checkout AntennaOffsetSet.java
checkout ApproachID.java
checkout BasicVehicleRole.java
checkout CoarseHeading.java
checkout ComputedLane.java
checkout Confidence.java
checkout DDateTime.java
checkout DDay.java
checkout DHour.java
checkout DMinute.java
checkout DMonth.java
checkout DOffset.java
checkout DSecond.java
checkout DYear.java
checkout DeltaAngle.java
checkout DescriptiveName.java
checkout DrivenLineOffsetLg.java
checkout DrivenLineOffsetSm.java
checkout Elevation.java
checkout ElevationConfidence.java
checkout FullPositionVector.java
checkout FullRoadAuthorityID.java
checkout GNSSstatus.java
checkout Heading.java
checkout HeadingConfidence.java
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
checkout Longitude.java
checkout MergeDivergeNodeAngle.java
checkout MinuteOfTheYear.java
checkout MsgCount.java
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
checkout Position3D.java
checkout PositionConfidence.java
checkout PositionConfidenceSet.java
checkout PositionalAccuracy.java
checkout PrioritizationResponseStatus.java
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
checkout RestrictionClassID.java
checkout RoadAuthorityID.java
checkout RoadRegulatorID.java
checkout RoadSegmentID.java
checkout RoadSegmentReferenceID.java
checkout RoadwayCrownAngle.java
checkout Scale_B12.java
checkout SegmentAttributeXY.java
checkout SegmentAttributeXYList.java
checkout SemiMajorAxisAccuracy.java
checkout SemiMajorAxisOrientation.java
checkout SemiMinorAxisAccuracy.java
checkout SignalGroupID.java
checkout Speed.java
checkout SpeedConfidence.java
checkout SpeedLimitList.java
checkout SpeedLimitType.java
checkout SpeedandHeadingandThrottleConfidence.java
checkout StationID.java
checkout TemporaryID.java
checkout ThrottleConfidence.java
checkout TimeConfidence.java
checkout TimeOffset.java
checkout TransmissionAndSpeed.java
checkout TransmissionState.java
checkout VehicleID.java
checkout VehicleType.java
checkout Velocity.java
checkout VertOffset_B12.java
checkout VerticalAcceleration.java
checkout YawRate.java

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

MODULE=REGION
checkout Reg_AdvisorySpeed.java
checkout Reg_ComputedLane.java
checkout Reg_ConnectionManeuverAssist.java
checkout Reg_GenericLane.java
checkout Reg_IntersectionGeometry.java
checkout Reg_IntersectionState.java
checkout Reg_LaneAttributes.java
checkout Reg_LaneDataAttribute.java
checkout Reg_MapData.java
checkout Reg_MovementEvent.java
checkout Reg_MovementState.java
checkout Reg_NodeAttributeSetXY.java
checkout Reg_NodeOffsetPointXY.java
checkout Reg_PersonalSafetyMessage.java
checkout Reg_Position3D.java
checkout Reg_RTCMcorrections.java
checkout Reg_RequestorDescription.java
checkout Reg_RequestorType.java
checkout Reg_RestrictionUserType.java
checkout Reg_RoadSegment.java
checkout Reg_SPAT.java
checkout Reg_SignalControlZone.java
checkout Reg_SignalRequest.java
checkout Reg_SignalRequestMessage.java
checkout Reg_SignalRequestPackage.java
checkout Reg_SignalStatus.java
checkout Reg_SignalStatusMessage.java
checkout Reg_SignalStatusPackage.java

MODULE=RTCMcorrections
checkout RTCM_Revision.java
checkout RTCMcorrections.java

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
